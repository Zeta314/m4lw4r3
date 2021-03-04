[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/Zeta314/m4lw4r3">
    <img src="images/logo.jpg" alt="Logo" width="150" height="150">
  </a>

  <h3 align="center">M4lw4r3 language</h3>

  <p align="center">
    It's an assembly-like language that I made for fun, while in quarantine.
    <br />
    <a href="https://github.com/Zeta314/m4lw4r3"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/Zeta314/m4lw4r3/issues">Report Bug</a>
    ·
    <a href="https://github.com/Zeta314/m4lw4r3/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<h2 style="display: inline-block">Table of Contents</h2>
<ol>
  <li>
    <a href="#about-the-project">About The Project</a>
    <ul>
      <li><a href="#built-with">Built With</a></li>
    </ul>
  </li>
  <li><a href="#script-examples">Script examples</a></li>
  <li><a href="#roadmap">Roadmap</a></li>
  <li><a href="#contributing">Contributing</a></li>
  <li><a href="#license">License</a></li>
  <li><a href="#contact">Contact</a></li>
  <li><a href="#acknowledgements">Acknowledgements</a></li>
</ol>


## About The Project

M4lw4r3 (or malware), is an assembly-like language (at least for its syntax) that I developed for fun, to learn more
about how machines work (and to use some of the free time that I had while in quarantine).

The language is interpreted, the scripts are directly parsed from the interpreter and executed immediately after.

### Built With

* [JNA](https://github.com/java-native-access/jna)
* [Maven](https://maven.apache.org/)
* [Java 14](https://www.java.com/en/)

## Script examples

- **STDIN ECHO**
```
LABEL loop
	READC R0
	WRITEB R0 R1
	ADDC R1 1
	
	COMPAREC R0 0xd
	REACHNZ loop

SETR R1 0
LABEL print
	LOADB R1 R0
	WRITEC R0
	ADDC R1 1
	
	COMPAREC R0 0x00
	REACHNZ print

SETR R2 0x0a
WRITEC R2
``` 
 
- **SIMPLE CALCULATOR**
```
WRITESC R0 "Operation: "
WRITES R0

READC R0
WRITEC R0
SUBC R0 0x30

COMPAREC R0 0
REACHS number-error
COMPAREC R0 9
REACHG number-error

READC R1
WRITEC R1

READC R2
WRITEC R2
SUBC R2 0x30

COMPAREC R2 0
REACHS number-error
COMPAREC R2 9
REACHG number-error

COMPAREC R1 0x2f
REACHZ div
COMPAREC R1 0x2d
REACHZ sub
COMPAREC R1 0x2b
REACHZ sum
COMPAREC R1 0x2a
REACHZ mul
REACH print-error

LABEL sum
    ADD R0 R2
    REACH print-result

LABEL sub
    SUB R0 R2
    REACH print-result

LABEL mul
    MULT R0 R2
    REACH print-result

LABEL div
    DIV R0 R2
    REACH print-result

LABEL print-result
    SETR R3 0x3d
    WRITEC R3
    ADDC R0 0x30
    WRITEC R0

    COMPAREC CA 0
    REACHZ print-newline

    SETR R3 32
    WRITEC R3

    SETR R3 0x28
    WRITEC R3
    ADDC CA 0x30
    WRITEC CA
    SETR R3 0x29
    WRITEC R3

    LABEL print-newline
    SETR R3 0x0a
    WRITEC R3
    REACH exit

LABEL print-error
    SETR R0 0x0a
    WRITEC R0
    SETR R0 0x00
    WRITESC R0 "Invalid operand."
    WRITES R0
    SETR R0 0x0a
    WRITEC R0
    REACH exit

LABEL number-error
    SETR R0 0x0a
    WRITEC R0
    SETR R0 0x00
    WRITESC R0 "That's not a number, dumbass."
    WRITES R0
    SETR R0 0x0a
    WRITEC R0

LABEL exit
```

_For more examples, please refer to the [Documentation](https://github.com/Zeta314/m4lw4r3/wiki)_


## Roadmap

See the [open issues](https://github.com/Zeta314/m4lw4r3/issues) for a list of proposed features (and known issues).


## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.
Project Link: [https://github.com/Zeta314/m4lw4r3](https://github.com/Zeta314/m4lw4r3)


<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/Zeta314/m4lw4r3.svg?style=for-the-badge
[contributors-url]: https://github.com/Zeta314/m4lw4r3/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Zeta314/m4lw4r3.svg?style=for-the-badge
[forks-url]: https://github.com/Zeta314/m4lw4r3/network/members
[stars-shield]: https://img.shields.io/github/stars/Zeta314/m4lw4r3.svg?style=for-the-badge
[stars-url]: https://github.com/Zeta314/m4lw4r3/stargazers
[issues-shield]: https://img.shields.io/github/issues/Zeta314/m4lw4r3.svg?style=for-the-badge
[issues-url]: https://github.com/Zeta314/m4lw4r3/issues
[license-shield]: https://img.shields.io/github/license/Zeta314/m4lw4r3.svg?style=for-the-badge
[license-url]: https://github.com/Zeta314/m4lw4r3/blob/master/LICENSE.txt
