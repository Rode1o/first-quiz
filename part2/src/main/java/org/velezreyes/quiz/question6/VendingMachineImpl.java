package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {
  private int insertedAmount;  // Variable para rastrear la cantidad de dinero insertado.

  @Override
  public void insertQuarter() {
    // Implementa el código para insertar un cuarto (25 centavos) en la máquina.
    insertedAmount += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    // Implementa el código para procesar la selección de bebida.
    // Asegúrate de manejar los casos de NotEnoughMoneyException y UnknownDrinkException.

    if ("ScottCola".equals(name)) {
      if (insertedAmount >= 75) {
        // Si hay suficiente dinero, entrega la bebida "ScottCola" y réstale el costo.
        insertedAmount -= 75;
        return new DrinkImpl("ScottCola", true);
      } else {
        throw new NotEnoughMoneyException();
      }
    } else if ("KarenTea".equals(name)) {
      if (insertedAmount >= 100) {
        // Si hay suficiente dinero, entrega la bebida "KarenTea" y réstale el costo.
        insertedAmount -= 100;
        return new DrinkImpl("KarenTea", false);
      } else {
        throw new NotEnoughMoneyException();
      }
    } else {
      // Si el nombre de la bebida no es reconocido, lanza una excepción UnknownDrinkException.
      throw new UnknownDrinkException();
    }
  }

  public static VendingMachine getInstance() {
    // Retorna una instancia de la máquina expendedora.
    return new VendingMachineImpl();
  }
}
