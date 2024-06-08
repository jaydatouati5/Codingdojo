from flask import Flask,render_template,request,redirect
from user import User

app=Flask(__name__)

@app.route("/")
def read():
    all_users = User.get_all()
    return render_template("read.html" , all = all_users)

@app.route("/create_page")
def display():
    return render_template("create.html")

@app.route("/create" , methods=['POST'])
def create():
    data = request.form
    User.create(data)
    return redirect('/')


if __name__ == '__main__':
    app.run(debug=True)
