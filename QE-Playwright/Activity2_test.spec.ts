import { test } from "@playwright/test";

test("Activity-2", async({page}) => {
    await page.goto("https://training-support.net/webelements/simple-form");

    console.log(await page.title());

    await page.fill("#full-name", "Nani");
    await page.fill("#email", "nani@gmail.com");
    await page.fill("input[type='date']", "2026-02-21");
    await page.fill("#additional-details", "It's Important");

    await page.click("text=Submit");

    await page.locator("#action-confirmation").waitFor();

    const confirm = await page.locator("#action-confirmation").textContent();

    console.log(confirm);

})