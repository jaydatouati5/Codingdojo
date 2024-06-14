from flask_app import app ,redirect,render_template ,request
from flask_app.models.dojo import Dojo


@app.route('/')
def home():
    dojos = Dojo.get_all()
    return render_template('home.html',all_dojos = dojos)

@app.route('/add_dojo' ,methods = ['POST'])
def create_dojo():
    data = request.form
    Dojo.save(data)
    return redirect('/')


@app.route('/dojo/<int:id>')
def show_dojo(id):
    data = {
        'id':id
        }
    golo = Dojo.get_dojo_with_ninja(data)
    return render_template('ninja_table.html', dojo = golo)
