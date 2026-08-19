

###

<div align="center">
  <img src="https://github-readme-stats.vercel.app/api/pin/?username=Alvarado007&repo=Primer-miniproyecto-java&theme=dracula" height="150" alt="project stats" />
</div>

###

<img align="right" height="150" src="https://i.gifer.com/origin/7d/7dab25c7b14a249bbc4790176883d1c5_w200.gif?cid=6c09b952llhupk66joic0ml8gbch148n2dfdqsvzj7z7f0em&ep=v1_gifs_search&rid=200w.gif&ct=g"  />

###

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="30" alt="java logo" />
  <img width="12" />
  <img src="https://skillicons.dev/icons?i=vscode" height="30" alt="vscode logo" />
</div>

###
## 📦 Proyecto: Simulador de Batallas Pokémon (MVC)

Este proyecto es una simulación de combates entre Pokémon utilizando Java. El sistema permite que entrenadores elijan y enfrenten Pokémon con distintos ataques y tipos (agua, fuego, psíquico y eléctrico).

### ✨ Características:
- Simulación por consola y GUI de batallas entre Pokémon.
- Sistema de ataques con nombre, poder y tipo.
- Todo esta completamente dividido en carpetas siguiendo con la estructura del MVC y algunas externas para mayor orden y entendimiento del codigo.

### 📊 Diagrama de Flujo del Sistema MVC
```mermaid
graph TD
    %% Definición de los cuadros (nodos)
    ControladorInicio[**ControladorInicio**<br>────────────<br>- Inicio Vista<br>- boolean ESGUI<br>────────────<br>+ public ControladorInicio<br>+ public void IniciarJuego<br>+ public void INICIAR<br>+ public void CambiarVista<br>+ public void setESGUS<br>+ void IniciarCarga<br>+ Entrenador CargarEntrenador]

    VistaTerminalInicio[**inicioPokemonTerminal**<br>────────────<br>- Scanner scanner<br>- ControladorInicio Controlador<br>────────────<br>+ public InicioPokemonTerminal<br>+ public void setControlador<br>+ public void Iniciar]

    VistaGUIInicio[**InicioPokemon**<br>────────────<br>- javax.swing.JButton BotonJugar<br>- javax.swing.JLabel LabelFondoInicio<br>- javax.swing.JLabel LabelLogo<br>- javax.swing.JPanel PanelDeInicio<br>- javax.swing.JButton BotonTerminal<br>- javax.swing.JButton BotonCargarPartida<br>- void initComponents<br>────────────<br>+ ControladorInicio controlador<br>+ InicioPokemon<br>+ static void main<br>+ void actionPerformed<br>+ void SetControlador<br>+ void Iniciar]

    ControladorEntrenador[**ControladorEntrenadores**<br>────────────<br>- EntrenadoresInterface vista<br>- Entrenador entrenador1<br>- Entrenador entrenador2<br>- boolean ESGUI<br>────────────<br>+ public ControladorEntrenadores<br>+ public void iniciar<br>+ public void crearEntrenadores<br>+ public void cambiarVista<br>+ public void setESGUI]

    VistaTerminalEntrenador[**EntrenadoresTerminal**<br>────────────<br>- Scanner scanner<br>────────────<br>+ ControladorEntrenadores controlador<br>+ EntrenadoresTerminal<br>+ void setControlador<br>+ void Iniciar<br>+ void Mostrar_equipo]
    
    VistaGUIEntrenador[**Entrenadores**<br>────────────<br>- void initComponents<br>- javax.swing.JButton BotonContinuar<br>- javax.swing.JLabel LabelEntrenador1<br>- javax.swing.JLabel LabelEntrenador2<br>- javax.swing.JLabel LabelEntrenadores<br>- javax.swing.JLabel LabelFondoEntrenadores<br>- javax.swing.JPanel PanelDeEntrenadores<br>- javax.swing.JTextField TextFieldEntrenador1<br>- javax.swing.JTextField TextFieldEntrenador2<br>- javax.swing.JButton BotonTerminal]

    ModeloEntrenador[**Modelo Entrenador**<br>────────────<br>- String nombre_entrenador<br>- ArrayList<Pokemon> equipo_entrenador<br>- byte contador_pokemones<br>────────────<br>+ String getNombre_entrenador<br>+ ArrayList<Pokemon> getEquipo_entrenador<br>+ void EliminarPokemon<br>+ Entrenador<br>+ void agregarPokemonEquipo<br>+ short randomVida<br>+ short randomDefensa<br>+ short randomVelocidad<br>+ short randomDefensaEspecial<br>+ short randomAtaque<br>+ void elegirPokemonBatallaAutomatico<br>+ void agregraAtaquesPokemonesAutomatico<br>+ void agregraAtaquesPokemonesAutomaticoEspeciales<br>+ void mostrarEquipo<br>+ static public HashMap getimagenes_front<br>+ static public HashMap getimagenes_Back<br>+ public HashMap getTipoPokemon<br>+ public HashMap getCounters<br>+ ArrayList getPokemones<br>+ void felicidad<br>+ void tristeza]
    
    ModeloPokemon[**Modelo Pokemon**<br>────────────<br>- String nombre<br>- ArrayList ataques<br>- TiposPokemon tipo<br>- short vida<br>- byte contadorataques<br>- TiposPokemon counter<br>────────────<br>+ short defensa<br>+ short velocidad<br>+ short defensaEspecial<br>+ short ataque<br>+ Pokemon<br>+ short getAtaque<br>+ void setAtaque<br>+ String getNombre<br>+ void setNombre<br>+ TiposPokemon getTipo<br>+ void setTipo<br>+ short getVida<br>+ void setVida<br>+ TiposPokemon getCounter<br>+ void setCounter<br>+ void addAtaque<br>+ void setAtaques<br>+ byte getContadorataques<br>+ void setContadorataques<br>+ short getDefensa<br>+ void setDefensa<br>+ short getVelocidad<br>+ void setVelocidad<br>+ short getDefensaEspecial<br>+ void setDefensaEspecial<br>+ ArrayList getAtaques<br>+ void mostrarAtaques<br>+ String toString<br>+ void atacar<br>+ void recibirDaño]

    ControladorSeleccionPokemon[**ControladorSeleccion**<br>────────────<br>- Interfaces.SeleccionPokemonInterface vista<br>- Entrenador entrenador1<br>- Entrenador entrenador2<br>- Batalla batalla<br>- boolean ESGUI<br>- Pila<br>────────────<br>+ ControladorSeleccion<br>+ void iniciar<br>+ void InicioBatalla<br>+ void setBatalla<br>+ void cambiarVista<br>+ void setESGUI<br>+ void Desicion<br>+ void IniciarGuardado<br>+ void GuardarPartida<br>+ void Vermovimientos<br>+ void setPila]
    
    VistaTerminalSeleccionPokemon[**SeleccionPokemonTerminal**<br>────────────<br>+ ControladorSeleccion controlador<br>+ Scanner scanner<br>+ SeleccionPokemonTerminal<br>+ void setControlador<br>+ void Iniciar<br>+ void Mensaje]
    
    VistaGUISeleccionPokemon[**SeleccionPokemon**<br>────────────<br>- void initComponents<br>- javax.swing.JButton BotonContinuarSeleccionPokemon<br>- javax.swing.JLabel LabelDeImagenEntrenador1<br>- javax.swing.JLabel LabelDeImagenEntrenador2<br>- javax.swing.JLabel LabelFondoSeleccionPokemon<br>- javax.swing.JLabel LabelNombreEntrenador1<br>- javax.swing.JLabel LabelNombreEntrenador2<br>- javax.swing.JList<Pokemon> ListEntrenador1<br>- javax.swing.JList<Pokemon> ListEntrenador2<br>- javax.swing.JPanel jPanel1<br>- javax.swing.JScrollPane jScrollPane1<br>- javax.swing.JScrollPane jScrollPane3<br>- javax.swing.JButton BotonTerminal<br>- javax.swing.JButton BotonGuardarPartida<br>- javax.swing.JButton BotonVerMovimientos<br>- JScrollPane scroll<br>- JTextArea area<br>────────────<br>+ ControladorSeleccion controlador<br>+ Pokemon PokemonGuardado<br>+ int ContadorEntrenadorTotal<br>+ SeleccionPokemon<br>+ static void main<br>- void actionPerformed<br>+ void setControlador<br>+ void Iniciar<br>+ void Mensaje]

    ControladorBatalla[**ControladorBatalla**<br>────────────<br>- Pokemon pokemon1<br>- Pokemon pokemon2<br>- BatallaInterface vista<br>- Batalla batalla<br>- boolean ESGUI<br>────────────<br>+ void iniciar<br>+ void atacar<br>+ Byte get_turno<br>+ Byte get_contadorAtaque1<br>+ Byte get_contadorAtaque2<br>+ void Regreso<br>+ void cambiarVista<br>+ void setESGUI<br>+ BatallaPokemon CastingVista<br>+ void MensajeTurno<br>+ String vida1<br>+ String vida2]
    
    VistaTerminalBatalla[**BatallaPokemonTerminal**<br>────────────<br>+ ControladorBatalla controlador<br>+ Scanner scanner<br>+ BatallaPokemonTerminal<br>+ void setControlador<br>+ void Iniciar<br>+ void Mensaje<br>+ void Borrar]
    
    VistaGUIBatalla[**BatallaPokemon**<br>────────────<br>- void initComponents<br>- javax.swing.JButton jButton1<br>- javax.swing.JButton jButton2<br>- javax.swing.JButton jButton3<br>- javax.swing.JButton jButton4<br>- javax.swing.JButton jButton5<br>- javax.swing.JButton jButton6<br>- javax.swing.JButton jButton7<br>- javax.swing.JButton jButton8<br>- javax.swing.JButton BotonTerminal<br>- javax.swing.JLabel jLabel1<br>- javax.swing.JLabel jLabel2<br>- javax.swing.JLabel jLabel3<br>- javax.swing.JLabel jLabel4<br>- javax.swing.JLabel jLabel5<br>- javax.swing.JLabel jLabel6<br>- javax.swing.JLabel jLabel7<br>- javax.swing.JPanel jPanel2<br>────────────<br>+ ControladorBatalla controlador<br>+ BatallaPokemon<br>+ static void main<br>+ void Ocultarbotones<br>+ void actionPerformed<br>+ void setControlador<br>+ void Iniciar<br>+ void actualizar<br>+ void Mensaje<br>+ void Borrar]

    ExcepcionDeRangoIndice[**ExcepcionDeRangoIndice**<br>────────────<br>+ ExcepcionDeRangoIndice]

    ExcepcionVacioGUI[**ExcepcionVacioGUI**<br>────────────<br>+ ExcepcionVacioGUI**]

    %% Conexiones entre los cuadros
    ControladorInicio --> VistaTerminalInicio
    ControladorInicio --> ControladorEntrenador
    ControladorInicio --> VistaGUIInicio

    ControladorEntrenador --> VistaTerminalEntrenador
    ControladorEntrenador --> ControladorSeleccionPokemon
    ControladorEntrenador --> ModeloEntrenador
    ControladorEntrenador --> VistaGUIEntrenador

    ModeloEntrenador --> ModeloPokemon

    ControladorSeleccionPokemon --> VistaTerminalSeleccionPokemon
    ControladorSeleccionPokemon --> ControladorBatalla
    ControladorSeleccionPokemon --> VistaGUISeleccionPokemon

    ControladorBatalla --> VistaTerminalBatalla
    ControladorBatalla --> ControladorSeleccionPokemon
    ControladorBatalla --> VistaGUIBatalla

    ExcepcionDeRangoIndice --> VistaTerminalInicio
    ExcepcionDeRangoIndice --> VistaTerminalEntrenador
    ExcepcionDeRangoIndice --> VistaTerminalSeleccionPokemon
    ExcepcionDeRangoIndice --> VistaTerminalBatalla

    ExcepcionVacioGUI --> VistaGUIEntrenador

    
```
###
<img align="right" height="150" src="https://i.pinimg.com/originals/4e/fe/e1/4efee18cb06f3d2f8456a40d1e0460e7.gif?cid=6c09b952llhupk66joic0ml8gbch148n2dfdqsvzj7z7f0em&ep=v1_gifs_search&rid=200w.gif&ct=g"  />

###

### 🛠️ Tecnologías
- Java ☕
- Visual Studio Code 💻

### 🚀 Cómo Ejecutar
1. Clona el repositorio:
```bash
git clone git@github.com:Alvarado007/Cuarto-miniproyecto-Java-presistencia-en-memoria.gits
```
2. Abre el proyecto en tu IDE favorito.
3. Asegúrate de tener Java instalado (Java 8+).
4. Ejecuta la clase `Main` (por implementar) o una clase de prueba que cree entrenadores y pokémon para simular batallas.

### 🧩 Estructuras Utilizadas
- La pila fue utilizada para guardar los movimientos realizados durante la batalla.
- El hash map fue utilizado para tener una relacion entre el nombre de los pokemones y sus gifts tanto de frente como de espalda asi mismo para relacionarlo tambien con su tipo y su counter.

### 👥 Autores
- Samuel Alvarado – [GitHub](https://github.com/Alvarado007) 202459469
- Santiago Arboleda – [GitHub](https://github.com/SantiagoA0408) 202459463
- Juan Manuel Gómez – [GitHub](https://github.com/JuanManuelG26706) 202459450

### 📬 Contacto
Si quieres mejorar este proyecto o darme sugerencias, no dudes en escribirme.

<div align="left">
  <img src="https://img.shields.io/static/v1?message=Gmail&logo=gmail&label=&color=D14836&logoColor=white&labelColor=&style=for-the-badge" height="35" alt="gmail logo"  />
  <img src="https://img.shields.io/static/v1?message=LinkedIn&logo=linkedin&label=&color=0077B5&logoColor=white&labelColor=&style=for-the-badge" height="35" alt="linkedin logo"  />
</div>

---

> Este es un proyecto académico con potencial para expandirse a una app con interfaz gráfica y lógica más compleja para torneos, niveles y más estrategia.


###

<div align="center">
  <img src="https://github-readme-stats.vercel.app/api/pin/?username=Alvarado007&repo=Primer-miniproyecto-java&theme=dracula" height="150" alt="project stats" />
</div>

###

<img align="right" height="150" src="https://i.gifer.com/origin/7d/7dab25c7b14a249bbc4790176883d1c5_w200.gif?cid=6c09b952llhupk66joic0ml8gbch148n2dfdqsvzj7z7f0em&ep=v1_gifs_search&rid=200w.gif&ct=g" />

###

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="30" alt="java logo" />
  <img width="12" />
  <img src="https://skillicons.dev/icons?i=vscode" height="30" alt="vscode logo" />
</div>

###

## 📦 Project: Pokémon Battle Simulator (MVC)

This project is a Pokémon battle simulator developed in Java. The system allows trainers to select and battle Pokémon with different attacks and types, including Water, Fire, Psychic, and Electric.

### ✨ Features

* Console-based and GUI-based Pokémon battle simulation.
* Attack system with names, power values, and types.
* The project is fully organized into packages following the MVC (Model-View-Controller) architecture, along with additional packages to improve code organization and readability.

### 📊 MVC System Flow Diagram

> **The Mermaid diagram remains unchanged from the original README.**

###

<img align="right" height="150" src="https://i.pinimg.com/originals/4e/fe/e1/4efee18cb06f3d2f8456a40d1e0460e7.gif?cid=6c09b952llhupk66joic0ml8gbch148n2dfdqsvzj7z7f0em&ep=v1_gifs_search&rid=200w.gif&ct=g" />

###

### 🛠️ Technologies

* Java ☕
* Visual Studio Code 💻

### 🚀 How to Run

1. Clone the repository:

```bash
git clone git@github.com:Alvarado007/Cuarto-miniproyecto-Java-presistencia-en-memoria.gits
```

2. Open the project in your preferred IDE.
3. Make sure Java is installed on your system (Java 8+).
4. Run the `Main` class (to be implemented) or a test class that creates trainers and Pokémon to simulate battles.

### 🧩 Data Structures Used

* A **stack** was used to store the moves performed during the battle.
* A **HashMap** was used to establish relationships between Pokémon names and their front and back GIFs, as well as their types and counters.
* **ArrayList** was used to manage Pokémon teams and their attacks.

### 👥 Authors

* Samuel Alvarado – [GitHub](https://github.com/Alvarado007) 202459469
* Santiago Arboleda – [GitHub](https://github.com/SantiagoA0408) 202459463
* Juan Manuel Gómez – [GitHub](https://github.com/JuanManuelG26706) 202459450

### 📬 Contact

If you would like to improve this project or have any suggestions, feel free to get in touch.

<div align="left">
  <img src="https://img.shields.io/static/v1?message=Gmail&logo=gmail&label=&color=D14836&logoColor=white&labelColor=&style=for-the-badge" height="35" alt="gmail logo" />
  <img src="https://img.shields.io/static/v1?message=LinkedIn&logo=linkedin&label=&color=0077B5&logoColor=white&labelColor=&style=for-the-badge" height="35" alt="linkedin logo" />
</div>

---

> This is an academic project with potential to be expanded into an application with a graphical interface and more complex game logic, including tournaments, levels, and additional strategic elements.

