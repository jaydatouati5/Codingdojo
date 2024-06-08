from mysqlconnection import connectToMySQL,DB

class User :
    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    # GET All (READ)

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users "
        results = connectToMySQL(DB).query_db(query)

        """
        results = [
        
            {'id' : 1 ,'first_name': jayda , 'last_name' : touati},
            {'id' : 3 ,'first_name': safa , 'last_name' : pancakes}
        ]
        """
        all_users = []
        for row in results:
            all_users.append(row)
        return all_users
    

    @classmethod
    def create(cls, data):
        query = "INSERT INTO users (first_name ,last_name, email) VALUES( %(first_name)s ,%(last_name)s, %(email)s);"
        return connectToMySQL(DB).query_db(query,data)