from flask_app.config.mysqlconnection import connectToMySQL , DB
from flask_bcrypt import Bcrypt
from flask_app import app
from flask import flash
import re

bcrypt = Bcrypt(app)

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    #CRUD
    @classmethod
    def create(cls,data):
        encrypted_password = bcrypt.generate_password_hash(data['password'])
        data = dict(data)
        data['password'] = encrypted_password
        query = "INSERT INTO users (first_name, last_name, email, password) VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s)"
        return connectToMySQL(DB).query_db(query, data)
    @classmethod
    def get_by_email(cls, data):
        query = "SELECT * FROM users WHERE email = %(email)s"
        result = connectToMySQL(DB).query_db(query, data)
        if result != ():
            return cls(result[0])
        return None 
    
    @staticmethod
    def validate_register(data):
        is_valid = True
        if len(data['first_name']) < 2 :
            flash('First name must be at least 2 characters long' ,'register')
            is_valid = False
        if len(data['last_name']) < 2 :
            flash('Last name must be at least 2 characters long','register')
            is_valid = False
        if not EMAIL_REGEX.match(data['email']):
            flash('Invalid email format','register')
            is_valid = False
        if (data['password']!= data['confirm_password']) :
            flash('Passwords do not match','register')
            is_valid = False
        # Check if email already exists
        user = User.get_by_email(data)
        if user:
            flash('Email already exists','register')
            is_valid = False
        return is_valid
    
    @staticmethod
    def validate_login(data):
        is_valid = True
        if not EMAIL_REGEX.match(data['email']):
            flash('Invalid email format','login')
            is_valid = False
        user = User.get_by_email(data)
        if not user:
            flash('Email does not exist','login')
            is_valid = False
        elif not bcrypt.check_password_hash(user.password, data['password']):
            flash('Incorrect password','login')
            is_valid = False
        return is_valid

