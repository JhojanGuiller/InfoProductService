conn = new Mongo();

db = conn.getDB("BankMicroServices");

var products = [
      {
        "idProducto": 1,
        "tipoProducto": "Cuenta Bancarias",
        "producto": "Ahorro"
      },
      {
        "idProducto": 2,
        "tipoProducto": "Cuenta Bancarias",
        "producto": "Corriente"
      },
      {
        "idProducto": 3,
        "tipoProducto": "Cuenta Bancarias",
        "producto": "A plazo fijo"
      },
      {
        "idProducto": 4,
        "tipoProducto": "Creditos",
        "producto": "Personal"
      },
      {
        "idProducto": 5,
        "tipoProducto": "Creditos",
        "producto": "Empresarial"
      },
      {
        "idProducto": 6,
        "tipoProducto": "Creditos",
        "producto": "Tarjeta Credito"
      },
      {
        "idProducto": 7,
        "tipoProducto": "Creditos",
        "producto": "Adelanto Efectivo"
      },
      {
        "idProducto": 8,
        "tipoProducto": "Cuenta Bancarias",
        "producto": "Ahorro personal VIP"
      },
      {
        "idProducto": 9,
        "tipoProducto": "Cuenta Bancarias",
        "producto": "Corriente personal VIP"
      },
      {
        "idProducto": 10,
        "tipoProducto": "Cuenta Bancarias",
        "producto": "Empresarial PYME"
      },
      {
        "idProducto": 11,
        "tipoProducto": "Cuenta Bancarias",
        "producto": "Empresarial Corporativo"
      },
      {
        "idProducto": 12,
        "tipoProducto": "Cuenta Bancarias",
        "producto": "A plazo fijo VIP"
      }
];

db.Products.insert(products);

db.Products.aggregate([
  {
    $addFields:{
            "_id":"$idProducto"
    }
  },
  {
    $project:{
            "idProducto":0
    }
  },
  {
    $out:"Products"
  }
]);
