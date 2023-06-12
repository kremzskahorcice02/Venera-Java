const audioPlayer = document.querySelector("audio");
const playPauseButton = document.querySelector("#play-pause-btn");
const previousButton = document.querySelector("#previous-btn");
const nextButton = document.querySelector("#next-btn");
const progressBar = document.getElementById('progress-bar');

let currentSong = 0;
let songs = [
  { title: "jak brzy je teď", src: "audio/01.mp3" },
  { title: "vzrušení z nul", src: "audio/02.mp3" },
  { title: "za zdí", src: "audio/03.mp3" },
  { title: "ve znamení Domina", src: "audio/04.mp3" },
  { title: "a nebe padalo", src: "audio/05.mp3" },
  { title: "v peřinách", src: "audio/06.mp3" },
  { title: "bez přistání", src: "audio/07.mp3" },
  { title: "dron", src: "audio/08.mp3" },
  { title: "tak blízko od sebe", src: "audio/09.mp3" }
];

function loadSong(song) {
  audioPlayer.src = song.src;
  document.getElementById("song-title").textContent = song.title;
}

function playSong() {
  audioPlayer.play();
  playPauseButton.innerHTML = '<i class="fas fa-pause"></i>';
}

function pauseSong() {
  audioPlayer.pause();
  playPauseButton.innerHTML = '<i class="fas fa-play"></i>';
}

// Get the current time and duration elements
const currentTime = document.getElementById('current-time');
const duration = document.getElementById('duration');

// When the audio file is loaded, set the duration
audioPlayer.addEventListener('loadedmetadata', function() {
  duration.textContent = formatTime(audioPlayer.duration);
});

// Update the progress bar as the audio plays
audioPlayer.addEventListener('timeupdate', function() {
  progressBar.value = (audioPlayer.currentTime / audioPlayer.duration) * 100;
  currentTime.textContent = formatTime(audioPlayer.currentTime);
});

playPauseButton.addEventListener("click", () => {
  if (audioPlayer.paused) {
    playSong();
  } else {
    pauseSong();
  }
});

previousButton.addEventListener("click", () => {
  currentSong--;
  if (currentSong < 0) {
    currentSong = songs.length - 1;
  }
  loadSong(songs[currentSong]);
  playSong();
});

nextButton.addEventListener("click", () => {
  currentSong++;
  if (currentSong > songs.length - 1) {
    currentSong = 0;
  }
  loadSong(songs[currentSong]);
  playSong();
});

progressBar.addEventListener('click', function(event) {
  const progressWidth = progressBar.offsetWidth;
  audioPlayer.currentTime = (event.offsetX / progressWidth) * audioPlayer.duration;
});

// Format the time in MM:SS format
function formatTime(time) {
  const minutes = Math.floor(time / 60);
  let seconds = Math.floor(time % 60);
  if (seconds < 10) {
    seconds = '0' + seconds;
  }
  return `${minutes}:${seconds}`;
}

loadSong(songs[currentSong]);