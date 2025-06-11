# 🎲 Ludo Game

A classic Ludo board game implementation in Java, bringing the beloved family game to your desktop!

## 📋 Table of Contents

- [About the Game](#about-the-game)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [How to Play](#how-to-play)
- [Game Rules](#game-rules)

- [Technologies Used](#technologies-used)
- [Screenshots](#screenshots)
- [License](#license)

## 🎮 About the Game

Ludo is a strategy board game for two to four players, in which the players race their four tokens from start to finish according to the rolls of a single dice. This Java implementation brings the classic game experience with an intuitive graphical interface and smooth gameplay.

## ✨ Features

- 🎯 **Classic Ludo Gameplay** - Traditional rules and mechanics
- 👥 **2-4 Player Support** - Play with friends or family
- 🎲 **Dice Rolling Animation** - Smooth and realistic dice rolls
- 🏠 **Safe Zones** - Protected squares for strategic gameplay
- 🏁 **Win Detection** - Automatic winner announcement
- 🎨 **Colorful UI** - Vibrant and engaging visual design
- ⚡ **Turn-based System** - Fair and organized gameplay
- 🔄 **Game Reset** - Start new games easily

## 🔧 Prerequisites

Before running this project, make sure you have:

- **Java Development Kit (JDK) 8 or higher**
- **VS Code** (recommended) or any Java IDE
- **Java Extension Pack** for VS Code (if using VS Code)

## 🚀 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/aditans/ludo-game.git
   cd ludo-game
   ```

2. **Open in VS Code**
   ```bash
   code .
   ```

3. **Compile and Run**
   - Open the project in VS Code
   - Navigate to the main class file
   - Run using the Java extension or terminal:
   ```bash
   javac -d bin src/*.java
   java -cp bin Main
   ```

## 🎯 How to Play

1. **Starting the Game**
   - Launch the application
   - Select number of players (2-4)
   - Each player chooses their color

2. **Gameplay**
   - Click the dice to roll
   - Move your tokens based on the dice value
   - Get all four tokens to the center to win!

3. **Controls**
   - **Left Click** - Roll dice / Select token to move
   - **Right Click** - Context menu (if available)

## 📜 Game Rules

### Basic Rules
- Each player starts with 4 tokens in their base
- Roll a **6** to bring a token out of the base
- Move tokens clockwise around the board
- Land on an opponent's token to send it back to base
- **Safe squares** protect tokens from being captured

### Winning
- First player to get all 4 tokens to the center wins
- Tokens must reach the center by exact count

### Special Rules
- Rolling a **6** gives an extra turn
- Three consecutive **6s** end your turn
- Tokens in safe zones cannot be captured



## 🛠️ Technologies Used

- **Java** - Core programming language
- **Java Swing/AWT** - GUI framework
- **Object-Oriented Programming** - Design methodology
- **Event-Driven Programming** - User interaction handling

## 📸 Screenshots

![Main UI](screenshots/Screenshot%202025-06-11%20222303.png)
![Main UI](screenshots/Screenshot%202025-06-11%20222314.png)
![Main UI](screenshots/Screenshot%202025-06-11%20222540.png)



## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### Ideas for Contributions
- Add sound effects
- Implement AI players
- Create different board themes
- Add network multiplayer support
- Improve UI/UX design

## 🐛 Known Issues

- List any known bugs or limitations here
- Performance issues on older systems (if any)
- Platform-specific issues (if any)

## 📋 TODO

- [ ] Add sound effects
- [ ] Implement save/load game functionality
- [ ] Create AI opponents
- [ ] Add different difficulty levels
- [ ] Implement online multiplayer

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Aditan S**
- GitHub: [@aditans](https://github.com/aditans)
- Repository: [ludo-game](https://github.com/aditans/ludo-game)

## 🙏 Acknowledgments

- Thanks to the creators of the original Ludo board game
- Java community for excellent documentation
- VS Code team for the amazing Java extension pack

---

**Enjoy playing Ludo! 🎉**

*Have fun and may the best player win!* 🏆
