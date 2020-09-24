<p>Minesweeper - project from hyperskill.org</p>
<p>This project simulates minespeer game</p>
<p>Implemented rules</p>
<ul>
<li>The game starts with an empty field.</li>
<li>The user can mark (flag) some cells as cells that potentially have a mine. Any empty cell can be flagged, not just the cells that do contain a mine. In the example, this is done by typing the word "mine" after entering the coordinates. After that, the cell is marked with a '*' (a mine flag).</li>
<li>The user can also remove flags from cells. In the example, the user simply types 'mine' again after entering the coordinates of the flagged cell. After that, it's marked as an empty cell.</li>
<li>The only way to get information about the field is to check it. In the example, this is done by typing 'free' after entering the coordinates of the cell. This means that the user thinks that this cell is free of mines and thus can be explored. Make the generation of mines as in the original game: the first cell checked cannot be a mine, it should always be empty. You can achieve this in many ways, it's up to you.</li>
<li>Obviously, if a cell has no mines around it, you can explore all the cells around it without any problems, so this should be done automatically by the program. Also, if there is another cell next to it with no mines around, the program should check all the cells around that cell as well, and so on until none can be checked automatically. In the example, all cells with no mines around are marked with a '/'. Keep in mind that if you encounter a cell marked '*' during this process, you must treat it as an empty cell and thus process as other cells and change it to '/' or to a number (because if it is near a '/' cell, it obviously cannot be a mine).</li>
<li>If the user wants to check a cell with 1 to 8 mines around it, the program should only expose that cell, because mines could be anywhere around it.</li>
<li>If the user wants to explore a cell that contains a mine, the user loses. After that, you can show all the mines on the field with symbol 'X'. This situation is shown in the first example.</li>
<li>If the user marks all the cells with potential mines, the user wins. Note that the user must mark all the mines, but no empty cells; if the user has extra flags that do not mark mines, they continue playing. After clearing all excess mine flags, the user wins. This situation is presented in the second example.</li>
<li>There is another way to win. The user can simply check all safe cells, leaving only the cells with mines unexplored. After that, the user wins. This situation is presented in the third example.</li>
</ul>


<p>To see short demonstration, please run demonstration.mp4 file</p>