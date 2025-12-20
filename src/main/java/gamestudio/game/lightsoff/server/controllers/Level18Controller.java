package gamestudio.game.lightsoff.server.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Level18Controller {
    public int[][] field = new int[5][5];

    private final int[][] level13 = {
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0}
    };

    public Level18Controller() {
        newGame();
    }

    @RequestMapping("/lightsoff/level18/new")
    public String newGame() {
        copyBoard(level13);
        return "redirect:/lightsoff/level18";
    }

    @GetMapping("/lightsoff/level18")
    public String level13(
            @RequestParam(value = "row", required = false) Integer row,
            @RequestParam(value = "column", required = false) Integer column,
            Model model) {

        if (row != null && column != null) {
            press(row, column);
        }

        model.addAttribute("htmlField", getHtmlField());
        return "level18";
    }

    @GetMapping("/lightsoff/level18/state")
    @ResponseBody
    public String getHtmlState() {
        return getHtmlField();
    }

    @GetMapping("/api/gameState/level18")
    @ResponseBody
    public String getGameState() {
        for (int[] r : field) {
            for (int cell : r) {
                if (cell == 1) return "KEEP GOING";
            }
        }
        return "WIN";
    }

    // ---------- Ігрова логіка ----------

    public void press(int i, int j) {
        toggle(i, j);
        toggle(i - 1, j);
        toggle(i + 1, j);
        toggle(i, j - 1);
        toggle(i, j + 1);
    }

    public void copyBoard(int[][] source) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = source[i][j];
            }
        }
    }

    public void toggle(int i, int j) {
        if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
            field[i][j] = (field[i][j] == 0) ? 1 : 0;
        }
    }

    public String getHtmlField() {
        StringBuilder sb = new StringBuilder("<table>");
        for (int r = 0; r < field.length; r++) {
            sb.append("<tr>");
            for (int c = 0; c < field[r].length; c++) {
                sb.append("<td>");
                sb.append("<a href='#' data-row='").append(r)
                        .append("' data-column='").append(c).append("'>");
                sb.append(field[r][c] == 1 ? "☀️" : "🌑");
                sb.append("</a>");
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
