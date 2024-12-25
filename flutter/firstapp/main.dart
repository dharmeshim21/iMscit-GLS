import 'package:flutter/material.dart';

void main() {
  runApp (MaterialApp(home: Scaffold(
    appBar: AppBar(title: Text("AppBar",style: TextStyle(fontSize: 44,fontStyle: FontStyle.italic,color: Colors.black),),
    backgroundColor: Colors.lightGreenAccent,
      centerTitle: true
    ),
    body: Text("This is body",style: TextStyle(fontSize: 24,fontStyle: FontStyle.italic,color: Colors.black)),
    backgroundColor: Colors.blueGrey

  ),));
}
