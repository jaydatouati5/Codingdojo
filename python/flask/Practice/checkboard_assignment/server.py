from flask import Flask , render_template


app =Flask(__name__)

@app.route('/')
def home():
    return render_template("index.html")

@app.route('/<int:num>')
def checkboard_number(num):
    return render_template ('index_number.html', num=num)

@app.route('/<int:x>/<int:y>')
def checkboard(x , y):
    return render_template ('index_3.html', x= x , y = y )


if __name__ == "__main__":
    app.run(debug = True , host="localhost" ,port = 7000)