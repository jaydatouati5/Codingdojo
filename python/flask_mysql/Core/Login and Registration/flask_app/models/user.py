from flask_app.config.mysqlconnection import connectToMySQL,DB
from flask_app import app
from flask import flash
import re
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)


class User:
    EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.confirm_password = data['confirm_password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def register (cls,data):

        encrypted_password = bcrypt.generate_password_hash(data['password'])
        data = dict(data)
        data['password']= encrypted_password

        encrypted_confirm = bcrypt.generate_password_hash(data['confirm_password'])
        data = dict(data)
        data['confirm_password']= encrypted_confirm

        query="INSERT INTO users (first_name, last_name, email, password, confirm_password) VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s,%(confirm_password)s);"
        return connectToMySQL(DB).query_db(query,data)
    

    @classmethod
    def get_by_id(cls , data):
        query = "SELECT * FROM users WHERE id = %(id)s;"
        results = connectToMySQL(DB).query_db(query , data)
        if results:
            return cls(results[0])
        return None
    
    @classmethod
    def get_by_email(cls , data):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        results = connectToMySQL(DB).query_db(query , data)

        if results:
            return cls(results[0])
        return None
    
    @staticmethod
    def validate_register(data):

        is_valid = True
        user_in_db = User.get_by_email(data)

        if len(data['first_name']) < 3:
            is_valid = False
            flash("Register: first name need to be longer than 3 characters" , "register")
        if len(data['last_name']) < 3:
            is_valid = False
            flash("Register: Last name need to be longer than 3 characters" , "register")
        if not User.EMAIL_REGEX.match(data['email']):
            is_valid = False
            flash("Register: Invalid email." , "register")
        if user_in_db:
            is_valid = False
            flash("Register: This email is already used." , "register")
        if len(data['password']) < 8:
            is_valid = False
            flash("Register: Password must be at least 8 characters long." , "register")
        if data['password'] != data['confirm_password']:
            is_valid = False
            flash("Register: Passwords must match", "register"  )
        return is_valid
    
    @staticmethod
    def validate_login(data):
        
        is_valid = True
        user_in_db = User.get_by_email(data)

        if not User.EMAIL_REGEX.match(data['email']):
            is_valid = False
            flash("Login: Invalid email." , "login")
        if not user_in_db:
            is_valid = False
            flash("Login: No user exists with this email." , "login")
        elif not bcrypt.check_password_hash(user_in_db.password , data['password']):
            is_valid = False
            flash("Login: Incorrect password." , "login")

        return is_valid