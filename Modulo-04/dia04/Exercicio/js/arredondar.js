Number.prototype.arredondar = function(casasDecimais = 2) {
  let casas =  Math.pow(10, casasDecimais);
  return Math.round(this * casas) / casas;
}
