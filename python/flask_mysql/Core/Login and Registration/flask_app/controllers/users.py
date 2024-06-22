from flask_app.models import user
from flask_app import app
from flask import render_template,request, redirect, session



@app.route('/')
def index():
    if 'user_id' in session:
        return redirect('/dashboard')
    return render_template("index.html")

@app.route('/register' , methods=["POST"])
def register():
    data = request.form
    if user.User.validate_register(data):
        user.User.register(data)
    return redirect('/')

@app.route('/login' , methods=["POST"])
def login():
    data = request.form
    if user.User.validate_login(data):
        one_user = user.User.get_by_email(data)
        session['id'] = one_user.id
        return redirect('/dashboard')
    return redirect('/')

@app.route('/dashboard')
def dash():
    data = {
        'id':session['id']
    }
    one_user = user.User.get_by_id(data)
    return render_template('dashboard.html',one_user = one_user)

@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')



