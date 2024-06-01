from flask import Flask ,render_template ,request,redirect,session

app = Flask(__name__)
app.secret_key= 'keepitsafe'

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/process', methods = ['POST'])
def processing():
    session['name']= request.form['name']
    session['dojo_location']= request.form['dojo_location']
    session['favorite_language']= request.form['favorite_language']
    session['comment']= request.form['comment']
    return redirect('/result')


@app.route('/result')
def result():
    return render_template('result.html' ,
                    full_name= session['name'] ,
                    dojo_loc = session['dojo_location'],
                    language = session['favorite_language'],
                    feedback = session['comment'])

if __name__ == "__main__":
    app.run(debug=True)