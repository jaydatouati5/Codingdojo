from flask_app.config.mysqlconnection import connectToMySQL, DB
from flask_app.models.ninja import Ninja


class Dojo:
    def __init__(self, data):
        self.id=data['id']
        self.name=data['name']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
        self.ninjas = []

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM dojos;"
        results = connectToMySQL(DB).query_db(query)
        dojos =[]
        for row in results:
            dojo = cls(row)
            dojos.append(dojo)
        return dojos

    @classmethod
    def save(cls ,data):
        query = "INSERT INTO dojos (name) VALUE (%(name)s);"
        return connectToMySQL(DB).query_db(query, data)

    @classmethod
    def get_dojo_with_ninja(cls ,data):
        query = """SELECT * FROM dojos LEFT JOIN ninjas ON dojos.id= ninjas.dojo_id WHERE dojos.id= %(id)s"""
        results = connectToMySQL(DB).query_db(query,data)

        dojo = cls(results[0])

        for row in results:
            ninja_data={
                'id':row['ninjas.id'],
                'first_name':row['first_name'],
                'last_name':row['last_name'],
                'age':row['age'],
                'created_at':row['ninjas.created_at'],
                'updated_at':row['ninjas.updated_at']
            }
            dojo.ninjas.append(Ninja(ninja_data))
        return dojo

