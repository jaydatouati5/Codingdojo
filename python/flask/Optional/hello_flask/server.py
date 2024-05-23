from flask import Flask
app = Flask(__name__)

@app.route('/')
def home():
    return 'welcome!'

@app.route('/hello/<name>')
def hello(name):
    print(name)
    return f"hello {name}"

@app.route('/success')
def success():
    return 'success'

@app.route('/hello/<string:name>/<int:num>')
def loop_name(name,num):
    return f"hello {name*num}"


if __name__=="__main__":
    app.run(debug=True,host="localhost",port=8000)