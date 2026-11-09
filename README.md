Aquí tienes la estructura en formato Markdown lista para el `README.md` de este código de **Simulación de Pasarela de Pagos Multicanal (Clases Abstractas, Herencia y Polimorfismo en Java)**, manteniendo el enfoque exclusivo de **Programación Orientada a Objetos en memoria** (sin bases de datos):

---

# 💳 Simulación de Pasarela de Pagos Multicanal (Clases Abstractas y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema financiero de pagos electrónicos, implementando una arquitectura basada en clases abstractas y herencia para administrar distintos medios de procesamiento (tarjetas de débito, criptomonedas y billeteras virtuales) con reglas de validación de saldo, comisiones por red y límites operativos diarios. Pone en práctica conceptos fundamentales de la **Programación Orientada a Objetos (POO)** como la **generalización de atributos protegidos (`protected`)**, la utilización de constructores mediante `super`, la implementación obligatoria de métodos abstractos (`abstract`), la sobrescritura polimórfica de comportamiento (`@Override`) y el procesamiento masivo de colecciones polimórficas en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base abstracta, sus respectivas subclases especializadas y un punto de ejecución:

* **`MedioPago` (Clase Abstracta)**: Centraliza los atributos y comportamientos comunes de cualquier instrumento de pago disponible en el sistema.
* **Atributos protegidos (`protected`)**: `titular`, `moneda` y `saldoDisponible`, permitiendo que las clases hijas accedan directamente a los datos financieros esenciales.
* **Constructor**: Inicializa los datos comunes de identificación y capital disponible de la cuenta.
* **Métodos operativos**:
* `abstract void procesarCobro(double monto)`: Método abstracto que obliga a todas las subclases a implementar su propia lógica transaccional.
* `mostrarComprobante(String medio, double monto)`: Método concreto compartido que imprime de manera estandarizada el comprobante de pago con el titular, la moneda, el canal y el monto operado.




* **`PagoTarjetaDebito`**: Extiende de `MedioPago` para modelar transacciones bancarias tradicionales mediante tarjeta.
* **Atributos privados (`private`)**: `numeroTarjeta` y `claveInterbancaria`.
* **Constructor**: Invoca a `super(...)` para configurar los datos base y el saldo.
* **Sobrescritura (`@Override`)**:
* `procesarCobro(double monto)`: Valida que el monto sea positivo y que el saldo sea suficiente antes de descontar los fondos e invocar `mostrarComprobante()`.




* **`PagoCriptomoneda`**: Extiende de `MedioPago` para modelar transferencias descentralizadas a través de redes blockchain.
* **Atributos privados (`private`)**: `direccionWallet` y `redBlockchain`.
* **Constructor**: Utiliza `super(...)` para la asignación de atributos heredados.
* **Sobrescritura (`@Override`)**:
* `procesarCobro(double monto)`: Comprueba la disponibilidad de fondos, simula el enrutamiento y confirmación de la red descentralizada, actualiza el saldo y genera el comprobante correspondiente.




* **`PagoBilleteraVirtual`**: Extiende de `MedioPago` para modelar cobros mediante aplicaciones digitales con topes de gasto diario.
* **Atributos privados (`private`)**: `alias`, `limiteDiario` y `montoUtilizadoHoy`.
* **Constructor**: Utiliza `super(...)`, asigna el alias y el límite máximo diario, inicializando el acumulador diario en cero (`0`).
* **Sobrescritura (`@Override`)**:
* `procesarCobro(double monto)`: Realiza una validación triple (monto positivo, saldo suficiente y respeto estricto del límite diario acumulado), actualiza el saldo, incrementa el consumo del día y emite el comprobante de pago.




* **`Main`**: Punto de entrada del programa. Inicializa un arreglo polimórfico de tipo `MedioPago` con instancias de tarjeta de débito, criptomonedas y billetera virtual, procesa una ronda de cobros mediante un bucle iterativo y ejecuta una segunda operación de prueba en la billetera virtual para demostrar el control de límites diarios.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Obligatoriedad Contractual (Clases Abstractas):** La clase `MedioPago` define el contrato mediante el método abstracto `procesarCobro`, garantizando que cada medio de pago implemente su propia regla transaccional.
2. **Validación Defensiva de Fondos y Topes:** Todas las operaciones verifican estrictamente que los montos sean mayores a cero y que no se rebasen los saldos disponibles ni los límites operativos configurados (como el tope diario de las billeteras virtuales).
3. **Procesamiento Polimórfico de Colecciones:** El uso de un arreglo de tipo base (`MedioPago[]`) permite recorrer y procesar de forma uniforme canales de pago radicalmente distintos en su lógica interna.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== SISTEMA DE PAGOS ELECTRÓNICOS =====

--- OPERACIÓN 1 ---
Pago con tarjeta aprobado.
===== COMPROBANTE DE PAGO =====
Titular: Juan Perez
Moneda: ARS
Medio de pago: Tarjeta de débito
Monto: 15000.0 ARS

--- OPERACIÓN 2 ---
Transacción enviada a la blockchain.
Red utilizada: Ethereum
Wallet: 0xABC123456
Transacción confirmada.
===== COMPROBANTE DE PAGO =====
Titular: Maria Lopez
Moneda: BTC
Medio de pago: Criptomoneda
Monto: 0.25 BTC

--- OPERACIÓN 3 ---
Pago con billetera virtual aprobado.
Alias: pedro.mp
===== COMPROBANTE DE PAGO =====
Titular: Pedro Gomez
Moneda: ARS
Medio de pago: Billetera virtual
Monto: 12000.0 ARS

--- SEGUNDO PAGO DE BILLETERA ---
Pago con billetera virtual aprobado.
Alias: pedro.mp
===== COMPROBANTE DE PAGO =====
Titular: Pedro Gomez
Moneda: ARS
Medio de pago: Billetera virtual
Monto: 25000.0 ARS

```

---

## 🚀 Conceptos de Programación Aplicados

* **Abstracción y Polimorfismo:** Uso de clases abstractas para definir plantillas de comportamiento común y permitir que cada subclase resuelva los detalles operativos de forma especializada.
* **Encapsulamiento de Estados Financieros:** Protección estricta de saldos, claves y límites transaccionales mediante modificadores de acceso.
* **Diseño Extensible:** Arquitectura abierta que permite incorporar nuevos medios de pago al sistema simplemente extendiendo la superclase abstracta sin alterar el código cliente existente.
