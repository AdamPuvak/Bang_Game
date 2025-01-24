<a id="readme-top"></a>

<!-- HEADER -->
<div align="center">
  <h3 align="center">Bang - Console Game</h3>
  <p align="center">
    Console-based version of the card game Bang, developed in Java.
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

This is a simplified version of the popular card game **Bang**. The game is played in a console, and the aim is to be the last player standing.

Players will battle it out in a turn-based system, drawing and playing cards with special effects to attack or defend, trying to eliminate other players. The game ends when only one player is left alive.

## Key Features

### Game Setup:

- **Players:** 2-4 players can join a game.
- **Starting Cards:** Each player starts with 4 cards and 4 health points. The number of health points is not limited.
  
### Gameplay:

- **Turns:** Each player’s turn consists of three steps:
  1. **Draw cards** – Draw two cards from the deck.
  2. **Play cards** – Play any number of cards (with restrictions on duplicates).
  3. **Discard excess cards** – Discard excess cards if the player has more cards than their health points.
  
- **Card Types:**
  - **Blue Cards** – Are placed in front player and last until they are removed (e.g., Barrel, Dynamite, Jail).
  - **Brown Cards** – Have immediate effects and are discarded after use (e.g., Bang, Beer, Stagecoach, Indians).

### Special Card Effects:

- **Bang**: Attack other players, causing them to lose health points.
- **Barrel**: Chance to avoid a Bang attack (1 in 4 chance).
- **Beer**: Gain 1 health point.
- **Stagecoach**: Draw 2 cards.
- **Indians**: Attack all other players (they must discard a Bang card or lose a life).
- **Cat Balou**: Discard a card from another player's hand or table.
- **Jail**: Imprison another player, preventing them from taking a turn unless they escape.
- **Dynamite**: Trigger a 1 in 8 chance to lose 3 health points, or pass it to another player.

### Goal:

The goal of the game is simple: **Be the last player alive**.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- TOOLS -->
### Built With

* [![Java][Java.com]][Java-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LINKS -->
[Java.com]: https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/

### Created

2023
