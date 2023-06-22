<!-- ===================================================================================== -->
<!-- ===================================================================================== -->
<!--                                                                                       -->
<!--        Project:    gameJam_21_06_23                                                   -->
<!--           Team:    Panic                                                              -->
<!--      Game name:    ...                                                                -->
<!--         Branch:    Main                                                               -->
<!--        Created:    2023-06-21                                                         -->
<!--    Last update:    2023-06-22                                                         -->
<!--         Author:    47128283                                                           -->
<!--                                                                                       -->
<!--        Repo URL:                                                                      -->
<!--         https://github.com/47128283/gameJam_21_06_23/                                 -->
<!--                                                                                       -->
<!-- ===================================================================================== -->
<!-- ===================================================================================== -->

<h1> MQ Game Jam 21/Jun/2023 </h1>

<h2> Brief </h2>

* game jam for macquarie university

<ul>
    <li><code>Ivan</code>
        <ul>
            <li><code>GITHUB</code> -- <code>https://github.com/47128283/</code></li>
            <li><code>EMAIL</code> -- <code>ivan.machamer@students.mq.edu.au</code></li>
            <li><code>DISCORD</code> -- <code>ivanisivan</code></li>
        </ul>
    </li>
    <li><code>AURORA</code>
        <ul>
            <li><code>GITHUB</code> -- <code>https://github.com/corbeau217</code></li>
            <li><code>EMAIL</code> -- <code>aurora.griffith@students.mq.edu.au</code></li>
            <li><code>DISCORD</code> -- <code>deadbeef.c</code></li>
        </ul>
    </li>
    <li><code>thursday-morning-aurora</code> branch is to be merged into <code>main</code> before splitting for afternoon branches</li>
</ul>

<!-- ===================================================================================== -->
<hr /><!-- =============================================================================== -->
<!-- ===================================================================================== -->

<h2>Project structure</h2>
<details>
  <summary><i>show / hide</i></summary>
  <ul>
    <li><b>File structure</b> <code>(</code><i>./game/src/*</i><code>)</code>
      <details>
        <summary><i>show / hide</i></summary>
        <ul>
          <li><code>CellIterator.java</code>
            <ul>
              <li><code>class CellIterator&lt;T&gt; implements Iterator&lt;T&gt;</code></li>
              <li><i></i></li>
            </ul>
          </li>
          <li><code>CorbLib.java</code>
            <ul>
              <li><i>Aurora's <code>Lib</code> file</i></li>
            </ul>
          </li>
          <li><code>Lib.java</code>
            <ul>
              <li><i>globally accessible variables and functions</i></li>
            </ul>
          </li>
          <li><code>Main.java</code>
            <ul>
              <li><i>main landing point and java runtime application/process instance creation</i></li>
            </ul>
          </li>
          <li><code>MapCell.java</code>
            <ul>
              <li><i>the base class for a cell in the map's grid</i></li>
            </ul>
          </li>
          <li><code>MapGrid.java</code>
            <ul>
              <li><i>the grid of rooms</i></li>
            </ul>
          </li>
          <li><code>PixelBox.java</code>
            <ul>
              <li><i>class for drawing pixel boxes</i></li>
            </ul>
          </li>
          <li><code>Player.java</code>
            <ul>
              <li><i>player handling</i></li>
            </ul>
          </li>
          <li><code>RoomGrid.java</code>
            <ul>
              <li><i>room's tile grid</i></li>
            </ul>
          </li>
          <li><code>RoomTile.java</code>
            <ul>
              <li><i>a specific tile in the room</i></li>
            </ul>
          </li>
          <li><code>RoomType.java</code>
            <ul>
              <li><i>tile type field</i></li>
            </ul>
          </li>
          <li><code>Seedable.java</code>
            <ul>
              <li><i>random number generation</i></li>
            </ul>
          </li>
          <li><code>Stage.java</code>
            <ul>
              <li><i>stage controller for game instance</i></li>
            </ul>
          </li>
          <li><code>TileType.java</code>
            <ul>
              <li><i>tile type object handling</i></li>
            </ul>
          </li>
        </ul>
      </details>
    </li>
    <li><b>Heirachy</b> (As at <code>[22/06/23][01:00pm]</code>)
      <details>
        <summary><i>show / hide</i></summary>
        <details>
          <summary><code>Main</code></summary>
          <ul><li><details>
            <summary><code>Main.App</code></summary>
            <ul><li><details>
              <summary><code>Stage</code></summary>
              <ul><li><details>
                <summary><code>MapGrid</code></summary>
                <ul><li><details>
                  <summary><code>MapCell[][]</code></summary>
                  <!-- item in 2d array of MapCell -->
                  <ul>
                    <li><i>reference: <code>MapCell</code></i>
                      <ul><li><details>
                        <summary><i>vars</i></summary>
                        <ul>
                          <li><code>Point parentSpaceOrigin</code>
                            <ul><li><i>insert-comments</i></li></ul>
                          </li>
                        </ul>
                      </details></li></ul>
                    </li>
                    <li><i>instance: <code>RoomGrid</code></i>
                      <ul>
                        <li><i>extends <code>MapCell</code> implements <code>Iterable&lt;RoomTile&gt;</code></i></li>
                        <li><details>
                          <summary><code>RoomTile[][]</code></summary>
                          <!-- item in 2d array of RoomTile -->
                          <ul><li>
                            <details>
                              <summary><i>vars</i></summary>
                              <ul>
                                <li><code>char hiddenType</code>
                                  <ul><li><i>the initial type</i></li></ul>
                                </li>
                                <li><code>char drawnType</code>
                                  <ul><li><i>the current type</i></li></ul>
                                </li>
                              </ul>
                            </details></li>
                          </li></ul>
                          <!-- end of item in 2d array of RoomTile -->
                        </details></li>
                      </ul>
                    </li>
                  </ul>
                  <!-- end of item in 2d array of RoomTile -->
                </details></li></ul>
              </details></li></ul>
            </details></li></ul>
          </details></li></ul>
        </details>
      </details>
    </li>
    <li><code></code></li>
    <li><code></code></li>
    <li><code></code></li>
  </ul>
</details>

<!-- ===================================================================================== -->
<hr /><!-- =============================================================================== -->
<!-- ===================================================================================== -->

<h2>Notices / Changes</h2>
<!-- notices / changes dropdown -->
<details>
    <summary><i>show / hide</i></summary>
    <ul>
        <li><code>[21/06/23]</code> ---> <i>init commit</i>
            <details>
                <summary><i>show / hide</i></summary>
                <ul>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                    <li><code>[02:04pm]</code> ---> <i>setup repository and the <code>readme.md</code> file</i></li>
                    <li><code>[03:05pm]</code> ---> <i>restructure of project and fleshing out the classes</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[03:26pm]</code> ---> <i><code>RoomGrid</code>, <code>MapGrid</code>, <code>MapCell</code>, <code>Stage</code> updates</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[04:36pm]</code> ---> <i>did the presentation</i></li>
                    <li><code>[05:05pm]</code> ---> <i>added in details to readme, added <code>Seedable</code>, began <code>RoomGrid</code></i></li>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                </ul>
            </details>
        </li>
        <li><code>[21/06/23]</code> ---> <i><code>Aurora</code>'s/<code>Corb</code>'s branch</i>
            <details>
                <summary><i>show / hide</i></summary>
                <ul>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                    <li><code>[05:18pm]</code> ---> <i>fixed date issue in readme and split for development</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[05:55pm]</code> ---> <i>added team name to readme.md</i></li>
                    <li><code>[05:55pm]</code> ---> <i>moved change log to new stub</i></li>
                    <li><code>[05:55pm]</code> ---> <i>added in tasks section</i></li>
                    <li><code>[06:25pm]</code> ---> <i>cleaned up <code>Seedable</code> and fleshed out implementation</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[07:52pm]</code> ---> <i>added in <code>PixelBox</code> implementatiion</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[10:54pm]</code> ---> <i>remade the <code>CellIterable&lt;T&gt;</code> class based on the one provided during OOPP unit with generics and null/empty protection</i></li>
                    <li><code>[11:03pm]</code> ---> <i>confirmed splitting of <code>Lib.java</code> development to <code>CorbLib.java</code> and <code>IvanLib.java</code></i></li>
                    <li><code>[11:03pm]</code> ---> <i>removed repeated code in <code>MapGrid</code></i></li>
                    <li><code>[11:03pm]</code> ---> <i>commented out junk in <code>Lib.java</code></i></li>
                    <li><code>[11:03pm]</code> ---> <i>created the <code>CorbLib.java</code> file</i></li>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                </ul>
            </details>
        </li>
        <li><code>[21/06/23]</code> ---> <i>Wed Night Ivan</i>
            <details>
                <summary><i>show / hide</i></summary>
                <ul>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                    <li><code>[05:18pm]</code> ---> <i>Created Branch</i></li>
                    <li><code>[00:00pm]</code> ---> <i>worked on room tile and room grid</i></li>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                </ul>
            </details>
        </li>
        <li><code>[22/06/23]</code> ---> <i><code>Aurora</code>'s/<code>Corb</code>'s branch</i>
            <details>
                <summary><i>show / hide</i></summary>
                <ul>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                    <li><code>[12:53am]</code> ---> <i>restructure <code>MapGrid</code> to use the <code>Iterator</code> functionality</i></li>
                    <li><code>[12:53am]</code> ---> <i>restructure <code>MapGrid</code> to handle painting</i></li>
                    <li><code>[12:53am]</code> ---> <i>added in untracted randomisation to <code>CorbLib.java</code> (for use in cases where seeds arent provided)</i></li>
                    <li><code>[12:53am]</code> ---> <i>added in setting up the courier font with try/catch handling</i></li>
                    <li><code>[12:53am]</code> ---> <i>filled out <code>Main</code> including nested <code>App</code> object which contains the <code>Stage</code> instance</i></li>
                    <li><code>[12:53am]</code> ---> <i>made the path of <code>Main</code>--&gt;<code>App</code>--&gt;<code>Stage</code>--&gt;<code>MapGrid</code> call/object structure</i></li>
                    <li><code>[12:53am]</code> ---> <i>added in some formatting and cleaned up <code>README.md</code> with ideas/tasks/plans</i></li>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                </ul>
            </details>
        </li>
        <li><code>[22/06/23]</code> ---> <i><code>thursday-morning-aurora</code> branch</i>
            <details>
                <summary><i>show / hide</i></summary>
                <ul>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                    <li><code>[10:00am]</code> ---> <i>finished merging <code>wed-night-...</code> branches into main</i></li>
                    <li><code>[10:00am]</code> ---> <i>creating branch and updating readme to reflect</i></li>
                    <li><code>[10:01am]</code> ---> <i>began work on trawling through code for any issues before beginning further tasks</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[10:13am]</code> ---> <i>cleaned up some implementation conflicts in <code>RoomGrid.java</code></i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[11:40am]</code> ---> <i>refactored <code>MapGrid</code>, <code>MapCell</code>, <code>RoomGrid</code>, <code>RoomTile</code>:</i>
                      <ul>
                        <li><i>to have correct constructor usage</i></li>
                        <li><i>to use <code>mousePos</code> paint function parameter</i></li>
                        <li><i>to have the type be stored in the structure</i></li>
                        <li><i>to then correctly use iterable and placeholders</i></li>
                        <li><i>cleaned up <code>toString()</code> functions</i></li>
                      </ul>
                    </li>
                    <li><code>[11:40am]</code> ---> <i>fixed up <code>settings.json</code> location and cleaned ammended indentation</i></li>
                    <li><code>[11:40am]</code> ---> <i>commiting changes before working on tidying up indentation</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[12:17pm]</code> ---> <i>pause on indentation fixing and had quick break, working on cleaning up drawing code now</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[12:23pm]</code> ---> <i>fixed url mistake in the day2.md</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[12:48pm]</code> ---> <i>added in <code>MouseListener</code> interface usage in <code>Main.App</code></i></li>
                    <li><code>[12:48pm]</code> ---> <i>added in handoff of <code>MouseEvent</code> to the  <code>Stage</code> instance inside a <code>Main.App</code> instance</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[12:48pm]</code> ---> <i>woops all documentation/refactoring</i></li>
                    <li><code>[12:48pm]</code> ---> <i>adding in comments to all the files to break apart and organise sections</i></li>
                    <li><code>[01:38pm]</code> ---> <i>literally burnt time on the heirachy thing in readme.md</i></li>
                    <li><code>[01:38pm]</code> ---> <i>removed unused <code>game/src/App.java</code></i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[01:41pm]</code> ---> <i>branched for <code>TileType</code> redesign into just characters</i></li>
                    <li><code>[01:41pm]</code> ---> <i>cryiing internally bc i wasted so much time on refactoring</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[02:41pm]</code> ---> <i>changed to using functions for drawing pixel boxes so completely depreciated the <code>PixelBox</code> object</i></li>
                    <li><code>[02:41pm]</code> ---> <i>working on the making the replace for room tile object declarations</li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[03:01pm]</code> ---> <i>woops submission happened</li>
                    <li><code>[03:01pm]</code> ---> <i>replaced the tile object declarations</li>
                    <li><code>[03:21pm]</code> ---> <i>we made pain irl</li>
                    <li><code>[03:21pm]</code> ---> <i>fiiinished adding in the types sorta?</li>
                    <li><code>[03:21pm]</code> ---> <i>started the room strings section</li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[00:00pm]</code> ---> <i></i></li>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                </ul>
            </details>
        </li>
        <li><code>[22/06/23]</code> ---> <i></i>
            <details>
                <summary><i>show / hide</i></summary>
                <ul>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                    <li><code>[00:00pm]</code> ---> <i></i></li>
                    <li><code>[00:00pm]</code> ---> <i></i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[00:00pm]</code> ---> <i></i></li>
                    <li><code>[00:00pm]</code> ---> <i></i></li>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                </ul>
            </details>
        </li>
        <li><code>[21/06/23]</code> ---> <i></i>
        <li></li>
        <li></li>
    </ul>
</details>

<!-- ===================================================================================== -->
<hr /><!-- =============================================================================== -->
<!-- ===================================================================================== -->

<h2>Plans</h2>
<!-- Plans dropdown -->
<details>
    <summary><i>show / hide</i></summary>
    <ul>
        <li><i>make working prototype with the object structure and basic details</i></li>
        <li><i>add in stats display</i></li>
        <li><i>add in input</i> (mouse input structure added)</li>
        <li><i></i></li>
        <li><i></i></li>
        <li></li>
        <li></li>
    </ul>
</details>

<!-- ===================================================================================== -->
<hr /><!-- =============================================================================== -->
<!-- ===================================================================================== -->

<h2>Ideas</h2>
<!-- Ideas dropdown -->
<details>
    <summary><i>show / hide</i></summary>
    <ul>
        <li><code> ===== ===== ===== ===== ===== </code></li>
        <li><code>[22/06/23]</code> ---> <i>Aurora's feature creeping</i>
            <details>
                <summary><i>show / hide</i></summary>
                <ul>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                    <li><code>[01:00am]</code> ---> <i>file handling for game data files (perhaps json files or just csv/txt?)</i></li>
                    <li><code>[01:00am]</code> ---> <i>setting for the game, using a settings file</i></li>
                    <li><code>[01:00am]</code> ---> <i>some way of checking the users display resolution to determine a default resolution</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[01:00am]</code> ---> <i>having it use image files without anti-aliasing instead of using rectangle shapes?</i></li>
                    <li><code>[01:00am]</code> ---> <i>right click menu?</i></li>
                    <li><code>[01:00am]</code> ---> <i>press a key to show the cost of things</i></li>
                    <li><code>[01:00am]</code> ---> <i>items list that the character has</i></li>
                    <li><code>[01:00am]</code> ---> <i>shop rooms?</i></li>
                    <li><code>[01:00am]</code> ---> <i>npc?</i></li>
                    <li><code>[01:00am]</code> ---> <i>perlin noise generation of somethiing idk?</i></li>
                    <li><code> ----- ----- ----- ----- ----- </code></li>
                    <li><code>[00:00pm]</code> ---> <i></i></li>
                    <li><code>[00:00pm]</code> ---> <i></i></li>
                    <li><code> ===== ===== ===== ===== ===== </code></li>
                </ul>
            </details>
        </li>
        <li><code> ----- ----- ----- ----- ----- </code></li>
        <li><code>[22/06/23][00:00pm]</code> ---> <code>person</code><i></i></li>
        <li><code>[22/06/23][00:00pm]</code> ---> <code>person</code><i></i></li>
        <li><code> ----- ----- ----- ----- ----- </code></li>
        <li><code>[22/06/23][00:00pm]</code> ---> <code>person</code><i></i></li>
        <li><code>[22/06/23][00:00pm]</code> ---> <code>person</code><i></i></li>
        <li><code> ===== ===== ===== ===== ===== </code></li>
    </ul>
</details>

<!-- ===================================================================================== -->
<hr /><!-- =============================================================================== -->
<!-- ===================================================================================== -->

<h2>Tasks</h2>
<!-- tasks dropdown -->
<details>
  <summary><i>show / hide</i></summary>
  <ul>
    <li><code> ===== ===== ===== ===== ===== </code></li>
    <li><code>[22/06/23][01:04am]</code> ---> <i>Aurora</i>
      <details>
        <summary><i>[ show / hide ]</i></summary>
        <ul>
          <li><i>branch wide</i>
            <ul>
              <li><code> ===== ===== ===== ===== ===== </code></li>
              <li><i>replace the tile thiingy with the new iin the cobrlib firle thingy how do type?</i></li>
              <li><i>make sure that room is then drawing the tiles correctly offset and not by position</i></li>
              <li><code> ===== ===== ===== ===== ===== </code></li>
            </ul>
          </li>
          <li><i><code>Stage</code> tasks:</i>
            <ul>
              <li><code> ===== ===== ===== ===== ===== </code></li>
              <li><i>add in <code>Player</code> instance holding</i></li>
              <li><code> ===== ===== ===== ===== ===== </code></li>
            </ul>
          </li>
        </ul>
      </details>
    </li>
    <li><code> ----- ----- ----- ----- ----- </code></li>
    <li><code>[22/06/23][11:46am]</code> ---> <i>Ivan</i>
      <details>
        <summary><i>[ show / hide ]</i></summary>
        <ul>
          <li><i><code>---</code> undefined:</i>
            <ul>
              <li><code> ===== ===== ===== ===== ===== </code></li>
              <li><i></i></li>
              <li><i></i></li>
              <li><code> ----- ----- ----- ----- ----- </code></li>
              <li><i></i></li>
              <li><i></i></li>
              <li><code> ===== ===== ===== ===== ===== </code></li>
            </ul>
          </li>
          <li><i><code>---</code> undefined:</i>
            <ul>
              <li><code> ===== ===== ===== ===== ===== </code></li>
              <li><i></i></li>
              <li><i></i></li>
              <li><code> ----- ----- ----- ----- ----- </code></li>
              <li><i></i></li>
              <li><i></i></li>
              <li><code> ===== ===== ===== ===== ===== </code></li>
            </ul>
          </li>
        </ul>
      </details>
    </li>
    <li><i><code>PROJECT-WIDE</code> tasks:</i>
      <ul>
        <li><code> ===== ===== ===== ===== ===== </code></li>
        <li><i>change indentation to be 2 spaces instead of 4 bc 4 is too much tbh</i></li>
        <li><i></i></li>
        <li><code> ===== ===== ===== ===== ===== </code></li>
      </ul>
    </li>
  </ul>
</details>

<!-- ===================================================================================== -->
<hr /><!-- =============================================================================== -->
<!-- ===================================================================================== -->

<h2>Issues</h2>
<!-- Issues dropdown -->
<details>
  <summary><i>show / hide</i></summary>
  <ul>
    <li><code> ===== ===== ===== ===== ===== </code></li>
    <li><code>[22/06/23][00:00pm]</code> ---> <i></i></li>
    <li><code>[22/06/23][00:00pm]</code> ---> <i></i></li>
    <li><code> ----- ----- ----- ----- ----- </code></li>
    <li><code>[22/06/23][00:00pm]</code> ---> <i></i></li>
    <li><code>[22/06/23][00:00pm]</code> ---> <i></i></li>
    <li><code>[22/06/23][00:00pm]</code> ---> <i></i></li>
    <li><code> ===== ===== ===== ===== ===== </code></li>
  </ul>
</details>

<!-- ===================================================================================== -->
<hr /><!-- =============================================================================== -->
<!-- ===================================================================================== -->
