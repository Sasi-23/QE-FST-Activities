import { test } from 'playwright/test';

test("Activity-4", async ({page}) => {
    await page.goto("https://training-support.net/webelements/drag-drop");
    console.log(await page.title());

    const ball = page.locator("#ball");
    const d1 = page.locator("#dropzone1");
    const d2 = page.locator("#dropzone2");

    await ball.dragTo(d1);
    console.log(await d1.textContent());

    await ball.dragTo(d2);
    console.log(await d2.textContent());
})