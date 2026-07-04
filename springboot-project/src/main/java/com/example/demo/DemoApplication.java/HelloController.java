package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/", produces = "text/html")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Hello %s</title>
                <style>
                    * { margin: 0; padding: 0; box-sizing: border-box; }
                    body {
                        min-height: 100vh;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        font-family: 'Segoe UI', Arial, sans-serif;
                        background: linear-gradient(135deg, #667eea 0%%, #764ba2 50%%, #f093fb 100%%);
                        background-size: 200%% 200%%;
                        animation: shift 8s ease infinite;
                    }
                    @keyframes shift {
                        0%%, 100%% { background-position: 0%% 50%%; }
                        50%% { background-position: 100%% 50%%; }
                    }
                    .card {
                        background: rgba(255, 255, 255, 0.15);
                        backdrop-filter: blur(12px);
                        border: 1px solid rgba(255, 255, 255, 0.3);
                        border-radius: 24px;
                        padding: 60px 80px;
                        text-align: center;
                        box-shadow: 0 20px 60px rgba(0, 0, 0, 0.25);
                        animation: pop 0.6s ease;
                    }
                    @keyframes pop {
                        from { opacity: 0; transform: scale(0.9) translateY(20px); }
                        to { opacity: 1; transform: scale(1) translateY(0); }
                    }
                    .emoji { font-size: 64px; }
                    h1 {
                        color: #fff;
                        font-size: 48px;
                        margin: 16px 0 8px;
                        text-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
                    }
                    h1 span {
                        background: linear-gradient(90deg, #ffe259, #ffa751);
                        -webkit-background-clip: text;
                        background-clip: text;
                        -webkit-text-fill-color: transparent;
                    }
                    p { color: rgba(255, 255, 255, 0.85); font-size: 18px; }
                    .badge {
                        display: inline-block;
                        margin-top: 24px;
                        padding: 8px 20px;
                        border-radius: 999px;
                        background: rgba(255, 255, 255, 0.25);
                        color: #fff;
                        font-size: 14px;
                        font-weight: 600;
                    }
                </style>
            </head>
            <body>
                <div class="card">
                    <div class="emoji">&#128075;</div>
                    <h1>Hello, <span>%s</span>!</h1>
                    <p>Your Spring Boot app is up and running.</p>
                    <div class="badge">&#9889; Spring Boot 3.4.1 &middot; Java 17</div>
                </div>
            </body>
            </html>
            """.formatted(name, name);
    }
}