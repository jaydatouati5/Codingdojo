from flask import Flask
app=Flask(__name__)

@app.route('/')
def hello():
    return "Hello world!"

@app.route('/Dojo')
def Dojo():
    return "Dojo!"

@app.route('/say/flask')
def hi_flask():
    return "Hi flask!"

@app.route('/say/michael')
def say_name():
    return "Hi Michael!"

@app.route('/say/jhon')
def greetin_name():
    return" Hi Jhon!"

@app.route('/repeat/<int:num>/<string:word>')
def rep(num,word):
    return f"{num*word}"

# @app.route('/repeat/<int:num>/<string:bye>')
# def by(num,bye):
#     return f"bye{num*bye}"

# @app.route('/repeat/<int:num>/<string:dogs>')
# def dog(num,dogs):
#     return f"dogs {num*dogs}"

if __name__=="__main__":
    app.run(debug=True)