from flask_app import app ,render_template ,redirect ,request
from flask_app.models.dojo import Dojo
from flask_app.models.ninja import Ninja

@app.route('/ninjas/new')
def create_ninja_page():
    dojos = Dojo.get_all()
    return render_template('new_ninja.html', dojos = dojos)

@app.route('/create/ninja' ,methods = ['POST'])
def new_ninja():
    Ninja.save(request.form)
    return redirect('/')





# @app.route('/ninja/info')
# def show():
#     one = Dojo.get_ninja_with_dojo()
#     return render_template ('ninja_table.html' , one = one)




