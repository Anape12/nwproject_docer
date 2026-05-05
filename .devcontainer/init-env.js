const fs = require("fs");

if (!fs.existsSync(".env")) {
  console.log("Creating .env from template...");
  fs.copyFileSync(".env.template", ".env");
} else {
  console.log(".env already exists");
}