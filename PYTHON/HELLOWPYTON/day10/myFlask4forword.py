from flask import  Flask, request, render_template

app = Flask(__name__)

@app.route("/")
def home():
    title = "리스트보기"
    myList = ["이휘로","박상영","최주형","변형균"]
    objList = []
    objList.append({'e_id' : '1','e_name' : '2', 'e_birth' : '3' })
    objList.append({'e_id' : '1','e_name' : '2', 'e_birth' : '3' })
    
    return render_template('test.html',data=myList, title=title, objList=objList)

if __name__ == "__main__":
    app.run(debug=True)