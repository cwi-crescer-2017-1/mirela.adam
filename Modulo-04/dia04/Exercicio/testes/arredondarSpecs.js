describe('arredondar', function() {

  it('deve arredondar 3.1428 para 3.14', function() {
    //arrange
    let pi = 3.1428;
    //act
    let resultado = pi.arredondar();
    //assert
    expect(resultado).toBe(3.14);
  });

  it('deve arredondar 5.0521 para 5.05', function() {
      // Arrange
      let entrada = 5.0521;
      // Act
      let resultado = entrada.arredondar();
      // Assert
      expect(resultado).toBe(5.05);
    });

    it('deve arredondar 5.0521 com 3 casas para 5.052', function() {
      // Arrange
      let entrada = 5.0521;
      // Act
      let resultado = entrada.arredondar(3);
      // Assert
      expect(resultado).toBe(5.052);
    });

  it('deve arredondar 3.14 com 0 casas para 3', function() {
  // Arrange
  let entrada = 3.14;
  // Act
  let resultado = entrada.arredondar(0);
  // Assert
  expect(resultado).toBe(3);
});
});
