# app.py
from flask import Flask

app = Flask(__name__)

@app.route('/')
def PrintRollno():
    return 'Roll no is 2313'