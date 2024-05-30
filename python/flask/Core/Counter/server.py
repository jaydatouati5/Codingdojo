from flask import Flask,render_template,session ,redirect,request

app = Flask(__name__)
app.secret_key='keepitsafe'

@app.route('/')
def counter_page():
    if 'counter' not in session:
        session['counter'] = 0
    else:
        session['counter'] += 1
    return render_template('index.html')

@app.route('/add_2')
def adding_by_2():
    session['counter'] += 1
    return redirect('/')

@app.route('/destroy_session')
def reset():
    session.clear()
    return redirect('/')

@app.route('/add_as_wants' ,methods = ['POST'])
def specified_number():
    session['counter'] += int(request.form['number'])-1
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)