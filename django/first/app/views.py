from django.shortcuts import render
from django.http import HttpResponse

def firstResponse(req):
    return HttpResponse("Hello Django")
