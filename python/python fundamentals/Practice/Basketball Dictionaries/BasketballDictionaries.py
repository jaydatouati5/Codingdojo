class Player:

    players = []

    def __init__(self,name,age,position,team):
        self = {
            "name" : name,
            "age" : age,
            "position" : position,
            "team":team  
        }
        Player.players.append(self)
    
    @classmethod
    def list_of_players (cls):
        new_team = []
        for i in Player.players:
            new_team.append(i)
        print(new_team)

player_kevin = Player("kevin", 34 , 'small forward' , "Brooklyn Nets")
player_jason = Player("jason", 24 , 'small forward' , "Boston Celtics")
player_kyrie = Player("kyrie", 32 , 'point Guard' , "Brooklyn Nets")

Player.list_of_players()



