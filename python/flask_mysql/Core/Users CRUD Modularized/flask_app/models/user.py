from flask_app.config.mysqlconnection import connectToMySQL ,DB

class User:
    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL(DB).query_db(query)

        all_users = []
        for row in results:
            user = cls(row)
            all_users.append(user)
        return all_users
    
    @classmethod
    def create(cls ,data):
        query = "INSERT INTO users (first_name , last_name , email) values (%(first_name)s,%(last_name)s,%(email)s)"
        return connectToMySQL(DB).query_db(query,data)
    
    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM users where id=%(id)s ;"
        result = connectToMySQL(DB).query_db(query,data)
        user = None
        if result != '':
            user= cls(result[0])
        return user
    
    @classmethod
    def update(cls,data):
        query = "UPDATE users SET first_name= %(first_name)s,last_name= %(last_name)s,email= %(email)s WHERE id=%(id)s;"
        return connectToMySQL(DB).query_db(query,data)
    
    @classmethod
    def delete(cls,data):
        query = "DELETE FROM users WHERE id=%(id)s;"
        return connectToMySQL(DB).query_db(query,data)