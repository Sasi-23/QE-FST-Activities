import { test, expect } from "@playwright/test";

test("has the right title", async ({ page }) => {

    await page.goto("https://training-support.net");

    await expect(page).toHaveTitle("Training Support");
});
