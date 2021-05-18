from flask import  Flask, request

app = Flask(__name__)

@app.route("/")
def home():
    a = request.args.get('a', "하하하")
    return "hello,{}".format(a)

if __name__ == "__main__":
    app.run(debug=True)