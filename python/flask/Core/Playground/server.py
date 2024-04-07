from flask import Flask,render_template
app=Flask(__name__)

@app.route('/')
def home():
    return "Hello flask!"

@app.route('/play')
def play():
    return render_template("index.html")


@app.route('/play/<int:num>')
def play_num(num):
    return render_template("play_num.html" , num = num )

@app.route('/play/<int:num>/<color>')
def colors(num,color):
    return  render_template('colors.html', num = num , color =color)

if __name__=="__main__":
    app.run(debug=True)