from flask import  render_template, request, redirect, session
from flask_app.models.user import User
from flask_app import app 

@app.route('/')
def index():
    if'logged_user_in' in session:
        return redirect('/recipes') 
    return render_template('index.html')

@app.route ('/register' , methods =['POST'])
def register():
    data = request.form
    if User.validate_register(data):
        User.create(data)
    return redirect('/')

@app.route('/login', methods =['POST'])
def login():
    data = request.form 
    if User.validate_login(data):
        session["logged_user_in"] = data['email']
        return redirect('/recipes')
    return redirect('/')

@app.route('/logout')
def logout():
    session.clear()
    return redirect('/') 