import { test } from "@playwright/test";

test('Activity1', async ({ page }) => {

  await page.goto('https://training-support.net');

  console.log(await page.title());

  await page.getByRole("link").filter({hasText: "About Us" }).click();
   
  await page.waitForURL(/about/);
  
  console.log(await page.title());

});
