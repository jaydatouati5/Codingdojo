from flask import Flask ,render_template,request, redirect
from user import User

app = Flask(__name__)


#!--------------------------reading all / ID----------------------------
#! get all
@app.route('/')
def read():
    all_users = User.get_all()
    return render_template ('read.html' , users = all_users)

#! get user by id
@app.route('/user/<int:id>')
def show(id):
    data = {'id':id}
    user = User.get_by_id(data)
    return render_template('show.html', user = user)

#!--------------------------adding---------------------------------------

#! user creating page
@app.route('/create_new')
def create ():
    return render_template('create_page.html')

#! add new user
@app.route('/create_user' ,methods = ['POST'])
def add_user():
    data = request.form
    User.create(data)
    return redirect('/')

#!--------------------------updating---------------------------------------
#! updating page
@app.route('/updating_page/<int:id>')
def modifying_page(id):
    data = {'id' : id}
    user = User.get_by_id(data)
    return render_template("modify.html", user = user)

#! edit user 
@app.route('/user_update' ,methods = ['POST'])
def modify():
    data = request.form
    User.update(data)
    return redirect ('/')

#!--------------------------deleting---------------------------------------

@app.route('/user/delete/<int:id>')
def delete(id):
    data = {'id' :id}
    User.delete(data)
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)