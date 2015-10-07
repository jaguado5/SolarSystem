Project
=======
My project consists in a Java program which display, in the computer console, text information about the solar system object passed to the program as input parameter.


Program: execution
==================
C:\coursera\SolarSystemIntro\Project>java -cp SolarSystem.jar SolarSystem  -h


Program usage
=============
usage: SolarSystem
 -h,--help           Show help.
 -p,--planet <arg>   [Mercury | Venus | Earth | Mars | Jupiter | Saturn | Uranus | Neptune | Pluto]
 -s,--star <arg>     [Sun]
 -m,--moon <arg>     [Moon]


Program usage example
=====================

C:\usr\coursera\SolarSystemIntro\Project>java -cp SolarSystem.jar SolarSystem  -p Earth

Planet Information: Earth
Orbital characteristics
        Epoch J2000[n 1]
        Aphelion 151930000 km (1.01559 AU)
        Perihelion 147095000 km (0.9832687 AU)
        Semi-major axis  149598261 km  (1.00000261 AU)
        Eccentricity 0.01671123
        Orbital period  365.256363004 d  (1.00001742096 yr)
        Average orbital speed  29.78 km/s  (107200 km/h)
        Mean anomaly  358.617 deg
        Inclination
                7.155 deg to Sun's equator;
                1.57869 deg to invariable plane;
                0.00005 deg to J2000 ecliptic
        Longitude of ascending node  -11.26064 deg to J2000 ecliptic
        Argument of perihelion  102.94719 deg
        Satellites  One natural satellite; 1265 operational artificial satellites
Physical characteristics
        Mean radius  6371.0 km
        Equatorial radius  6378.1 km
        Polar radius  6356.8 km
        Flattening 0.0033528  1/298.257222101 (ETRS89)
        Circumference 40075.017 km (equatorial)  40007.86 km (meridional)
        Surface area  510072000 km2  (148940000 km2 (29.2%) land  361132000 km2 (70.8%) water)
        Volume 1.08321×1012 km3
        Mass  5.97237×1024 kg  (3.0×10-6 solar mass)
        Mean density  5.514 g/cm3
        Surface gravity  9.807 m/s2 (1 g)
        Moment of inertia factor  0.3307
        Escape velocity  11.186 km/s
        Sidereal rotation period  0.99726968 d  (23h 56m 4.100s)
        Equatorial rotation velocity  1,674.4 km/h (465.1 m/s)
        Axial tilt  23.4392811°
        Albedo   0.367 geometric  0.306 Bond
        Surface temp. min  mean  max
                Kelvin   184K   288K 330K
                Celsius  -89.2°C 15°C 56.7°C
Atmosphere
        Surface pressure  101.325 kPa (at MSL)
        Composition by volume
                78.08% nitrogen (N2) (dry air)
                20.95% oxygen (O2)
                0.930% argon
                0.039% carbon dioxide
                ~1% water vapor (climate-variable)


Text files to add new objects
=============================
Three kind of objects are permitted as input parameter

- Planets: after the option "-p" the user can introduce one of the following objects: Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune or Pluto.

- Stars: after the option "-s" the user can introduce following object: Sun

- Moons: after the option "-m" the user can introduce following object: Moon


The program reads the information from three different text files: planet.txt, stars.txt and  moons.txt.   New planets, tars or moons information can be easily added to the program just inserted the desired text in the corresponding object.  In this case, it is necessary sepate each object inserted with a "=======" line. Also the name of the new object should appears in the first line of the added block.


Source code
===========
The file SolarSystem.java contains the source code of this program.


NOTE
====
All information contained in the planets, stars and moons files have been obtained from the wikipedia.
