from flask_app.config.mysqlconnection import connectToMySQL ,DB
from flask_app.models import  dojo


class Ninja:
    def __init__(self ,db_data):
        self.id = db_data['id']
        self.first_name = db_data['first_name']
        self.last_name = db_data['last_name']
        self.age = db_data['age']
        self.created_at = db_data['created_at']
        self.updated_at = db_data['updated_at']

    @classmethod
    def save(cls,data):
        query = "INSERT INTO ninjas (dojo_id,first_name,last_name,age) VALUES (%(dojo_id)s,%(first_name)s,%(last_name)s,%(age)s)"
        return connectToMySQL (DB).query_db(query,data)
