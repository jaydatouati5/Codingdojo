from flask import Flask,render_template

app = Flask(__name__)


@app.route("/")
def home():
    return "welcome"

@app.route("/play")
def level_1():
    return render_template ("level1.html")

@app.route("/play/<int:num>")
def level_2(num):
    return render_template("level2.html" , num = num)

@app.route("/play/<int:num>/<string:color>")
def level_3(num , color):
    return render_template("level3.html" , num = num, color = color)

if __name__=="__main__":
    app.run(debug=True)