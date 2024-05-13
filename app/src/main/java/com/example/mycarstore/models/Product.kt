package com.example.mycarstore.models

class Product {
    var carmodel:String = ""
    var carbrand:String = ""
    var price:String = ""
    var imageUrl:String = ""
    var mileage:String = ""
    var enginesize:String = ""
    var fueltype:String = ""
    var transmission:String = ""

    constructor(carmodel: String,carbrand: String, price: String, imageUrl: String, enginesize: String, fueltype: String, transmission: String, mileage: String) {
        this.carmodel = carmodel
        this.carbrand = carbrand
        this.price = price
        this.imageUrl = imageUrl
        this.mileage = mileage
        this.enginesize = enginesize
        this.fueltype = fueltype
        this.transmission = transmission
    }

    constructor()
}