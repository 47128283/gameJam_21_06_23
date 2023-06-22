//import java.awt.*;
// public abstract class TileType {
//     Color tileColor;
//     boolean isWalkable;
//     TileType() {
//         tileColor = new Color(0,0,0);
//     }

//     TileType(Color c, boolean w) {
//         this.tileColor = c;
//         this.isWalkable = w;
//     }
// }

// final class Boundary extends TileType {
//     Boundary() {
//         super(new Color(128,128,128), false);
//     }
// }

// final class Walkable extends TileType {
//     Walkable() {
//         tileColor = new Color(192,192,192);
//         isWalkable = true;
//     }
// }

// final class Item extends TileType {
//     Item(int i) {
//         switch(i) {
//             default:
//                 tileColor = new Color(255,255,0);
//                 isWalkable = true;
//             break;
//         }
//     }
// }

// final class Wildcard extends TileType {
//     Wildcard(int i) {
//         switch(i) {
//             default:
//                 tileColor = new Color(192,192,192);
//                 isWalkable = true;
//             break;
//         }
//     }
// }
