from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.
def login(req):
    return render(req,'index.html')

def register(req):
    return render(req,'signup.html')

def forgotPass(req):
    return render(req,'forgotpass.html')

def homePage(req):
    uname = 'dharmesh'
    passw = 'd191'
    username = req.GET.get("username")
    password = req.GET.get("password")
    return HttpResponse(username+":"+password)