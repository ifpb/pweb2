# Image and multimedia

* [Image URL](#image-url)
* [Raster vs Vector](#raster-vs-vector)
* [Data URI](#data-uri)
* [Image + Hyperlink](#image--hyperlink)
* [Figure](#figure)

## Image Structure
---

```html
<img src="url" alt="text alternative">
```

## Image URL
---

**home.html ➡︎ image.png**
```
/
└── var
    └── www
        └── site
            └── pages
                ├── home.html
                └── image.png
```

```html
<img src="image.png" alt="Image Description">
<img src="./image.png" alt="Image Description">
<img src="/pages/image.png" alt="Image Description"> (http)
<img src="http://site.com/pages/image.png" alt="Image Description"> (http)
<img src="/var/www/site/pages/image.png" alt="Image Description"> 👎
```

**home.html ➡︎ image.png**
```
/
└── var
    └── www
        └── site
            └── pages
                ├── home.html
                └── img
                    └── image.png
```

```html
<img src="img/image.png" alt="Image Description">
<img src="./img/image.png" alt="Image Description">
<img src="/pages/img/image.png" alt="Image Description"> (http)
<img src="http://site.com/pages/img/image.png" alt="Image Description"> (http)
<img src="/var/www/site/pages/img/image.png" alt="Image Description"> 👎
```

**home.html ➡︎ image.png**
```
/
└── var
    └── www
        └── site
            ├── pages
            |   └── home.html
            └── img
                └── image.png
```

```html
<img src="../img/image.png" alt="Image Description">
<img src="/img/image.png" alt="Image Description"> (http)
<img src="http://site.com/img/image.png" alt="Image Description"> (http)
<img src="/var/www/site/img/image.png" alt="Image Description"> 👎
```

**home.html ➡︎ image.png**
```
(/var/www/site = http://site.com/)
/
└── var
    └── www
        └── site
            └── home.html

(/var/www/site = http://othersite.com/)
/
└── var
    └── www
        └── site
            └── img
                └── image.png
```

```html
<img src="http://othersite.com/img/image.png" alt="Image Description"> (http)
```

## Raster vs Vector
---

<table>
  <tr>
    <th></th>
    <th>
      <h3 id="png-raster">PNG (Raster)</h3>
    </th>
    <th>
      <h3 id="svg-vector">SVG (Vector)</h3>
    </th>
  </tr>
  <tr>
    <th>width: 150px</th>
    <td>
      <img src="assets/ifpb-logo.png" alt="logo ifpb" width="150px">
    </td>
    <td>
      <img src="assets/ifpb-logo.svg" alt="logo ifpb" width="150px">
    </td>
  </tr>
  <tr>
    <th>width: 2000px</th>
    <td>
      <div style="width: 200px; height: 200px; background-image: url('assets/ifpb-logo.png'); background-size: 2000px;"></div>
    </td>
    <td>
      <div style="width: 200px; height: 200px; background-image: url('assets/ifpb-logo.svg'); background-size: 2000px;"></div>
    </td>
  </tr>
</table>

## Data URI
---

* [Image Data URI](https://css-tricks.com/data-uris/)
* [Data URI Generator](https://dopiaza.org/tools/datauri/index.php)

```html
<img src="data uri" alt="text alternative">
```

**data:image/png;base64**
```html
<img 
  src="data:image/png;base64,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" 
  alt="IFPB logo">
```

Output:

<div style="border-radius: 0.3rem; border: solid 1px #dce6f0; padding: 0.8rem">
  <img src="assets/ifpb.png" alt="logo ifpb">
</div>

## Image + Hyperlink
---

```html
<a href="url">
  <img src="url" alt="text alternative">
</a>
```

```html
<a href="http://ifpb.edu.br/">
  <img src="ifpb.png" alt="logo IFPB">
</a>
```

Output:

<div style="border-radius: 0.3rem; border: solid 1px #dce6f0; padding: 0.8rem">
  <a href="http://ifpb.edu.br/">
    <img src="assets/ifpb.png" alt="logo IFPB">
  </a>
</div>

## [&lt;figure>](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/figure)
---

```html
<figure>
  <img src="assets/ifpb.png" alt="logo IFPB">
  <figcaption>IFPB Logo</figcaption>
</figure>
```

Output:

<div style="border-radius: 0.3rem; border: solid 1px #dce6f0; padding: 0.8rem">
  <figure>
    <img src="assets/ifpb.png" alt="logo IFPB">
    <figcaption>IFPB Logo</figcaption>
  </figure>
</div>

## References
---

* Elements:
  * [`<img>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/img)
  * [`<figure>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/figure)
* Attributes:
  * [`<img>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a#Attributes): `src`, `alt`, `title`, `width`, `height`
