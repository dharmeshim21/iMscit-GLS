from django.shortcuts import render

def homePage(req):
    return render(req,"index.html")

def amdPage(req):
    return render(req,"amd.html")

def sciPage(req):
    return render(req,"sciencecity.html")