from flask_app.config.mysqlconnection import connectToMySQL, DB
from flask_app.models.user import User

class Recipe:
    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.instructions = data['instructions']
        self.date_cooked = data['date_cooked']
        self.under_30 = data['under_30']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user = None

    #CRUD OPERATIONS
    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM recipes join users ON recipes.user_id = users.id WHERE recipes.id = %(id)s"
        result = connectToMySQL(DB).query_db(query, data)
        if result == ():
            return None
        recipe = cls(result[0])
        user_data = {
            'id': result[0]['users.id'],
            'first_name': result[0]['first_name'],
            'last_name': result[0]['last_name'],
            'email': result[0]['email'],
            'password': result[0]['password'],
            'created_at': result[0]['users.created_at'],
            'updated_at': result[0]['users.updated_at']
        }   
        recipe.user = User(user_data) 
        return recipe
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM recipes join users ON recipes.user_id = users.id"
        results = connectToMySQL(DB).query_db(query)
        if results ==[]:
            return []
        recipes = []
        for result in results:
            recipe = cls(result)
            user_data = {
                'id': result['users.id'],
                'first_name': result['first_name'],
                'last_name': result['last_name'],
                'email': result['email'],
                'password': result['password'],
                'created_at': result['users.created_at'],
                'updated_at': result['users.updated_at']
            }
            recipe.user = User(user_data)
            recipes.append(recipe) 
        return recipes
    @classmethod
    def create(cls, data):
        query = "INSERT INTO recipes (name, description, instructions, date_cooked, under_30, user_id) VALUES (%(name)s, %(description)s, %(instructions)s, %(date_cooked)s, %(under_30)s, %(user_id)s)"
        return connectToMySQL(DB).query_db(query, data) 
    
    @classmethod
    def update(cls, data):
        query = "UPDATE recipes SET name=%(name)s, description=%(description)s, instructions=%(instructions)s, date_cooked=%(date_cooked)s, under_30=%(under_30)s WHERE id=%(id)s"
        return connectToMySQL(DB).query_db(query, data) 
    
    @classmethod
    def delete(cls, data):
        query = "DELETE FROM recipes WHERE id=%(id)s"
        return connectToMySQL(DB).query_db(query, data) 