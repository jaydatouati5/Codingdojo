from flask import render_template, request, redirect, session
from flask_app.models.recipe import Recipe
from flask_app.models.user import User
from flask_app import app 

@app.route('/recipes')
def recipes():
    if 'logged_user_in'not in session:
        return redirect('/') 
    user_data ={
        'email':session['logged_user_in']
    }
    user = User.get_by_email(user_data) 
    recipes = Recipe.get_all()
    return render_template('recipes.html', recipes=recipes, user=user)

@app.route('/recipes/new')
def new_recipe():
    if 'logged_user_in'not in session:
        return redirect('/') 
    user_data ={
        'email':session['logged_user_in']
    }
    user = User.get_by_email(user_data) 
    return render_template('create.html', user=user) 

@app.route('/add_recipe', methods=['POST'])
def create_recipe():
    data = request.form
    Recipe.create(data)
    return redirect('/recipes')

@app.route('/recipes/edit/<int:recipe_id>')
def show_recipe(recipe_id):
    if 'logged_user_in'not in session:
        return redirect('/') 
    user_data ={
        'email':session['logged_user_in']
    }
    user = User.get_by_email(user_data)
    recipe_data ={
        'id':recipe_id
    }
    recipe = Recipe.get_by_id(recipe_data)
    return render_template('edit.html', recipe=recipe, user=user)