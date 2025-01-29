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

### Game Setup

- **Players:** 2-4 players can join a game.
- **Starting Cards:** Each player starts with 4 cards and 4 health points. The number of health points is not limited.
  
### Gameplay

- **Turns:** Each player’s turn consists of three steps:
  1. **Draw cards** – Before drawing cards, player checks the effects of the **Dynamite** and **Jail** cards if they are in play. Then the player draws two cards from the deck.
  2. **Play cards** – Play any number of cards (Duplicates rule: Only one blue card of each type can be placed in front of a player at a time).
  3. **Discard excess cards** – Discard excess cards if the player has more cards than their health points.

- **Deck Reshuffle:** When the draw deck is exhausted, the discard pile is shuffled and used as the new draw deck.

### Card Distribution

- **Total Cards:** 71 cards in the game.
  - **Blue Cards:** 6 cards (2x Barrel, 1x Dynamite, 3x Jail).
  - **Brown Cards:** 65 cards (30x Bang, 15x Missed, 8x Beer, 6x Cat Balou, 4x Stagecoach, 2x Indians).

- **Card Types:**
  - **Blue Cards** – Are placed in front player and last until they are removed.
  - **Brown Cards** – Have immediate effects and are discarded after use.

### Cards Effects

- **Bang**: Attack other players, causing them to lose health points.
- **Missed**: If a player is targeted by a bang they can negate the attack by playing a **Missed** card. If they do not have a **Missed** card, they lose one health point.
- **Barrel**: Chance to avoid a Bang attack (1 in 4 chance).
- **Beer**: Gain 1 health point.
- **Stagecoach**: Draw 2 cards.
- **Indians**: Attack all other players (they must discard a Bang card or lose a life).
- **Cat Balou**: Discard a card from another player's hand or table.
- **Jail**: Imprison another player, preventing them from taking a turn unless they escape.
- **Dynamite**: Trigger a 1 in 8 chance to lose 3 health points, or pass it to another player.

### Goal

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
