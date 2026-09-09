# FPP Playlist Button

Provides the child device used by FPP Playlist Player to start a single Falcon Player playlist. Each child represents a playlist discovered by its parent.

## What it does

- Implements Hubitat’s `Momentary`, `Actuator`, and `Refresh` capabilities.
- **Push** records `lastPushed` and asks the parent to play the associated playlist.
- **Refresh** delegates a refresh to the parent.
- Has no preferences, network connection, or independent polling.

## Installation

1. Open **Drivers Code** in the Hubitat hub interface and create a new driver.
2. Paste [FPPPlaylistButton.groovy](FPPPlaylistButton.groovy) (or import the [raw source](https://raw.githubusercontent.com/b69ca/hubitat-fppplaylistbutton/main/FPPPlaylistButton.groovy)) and save it.
3. Install and configure [FPP Playlist Player](https://github.com/b69ca/hubitat-fppplaylistplayer).
4. Leave child creation enabled on the parent, then run its **Refresh** command. The parent creates and associates the playlist buttons.

Do not create this as an independent virtual device for playlist control. Without a parent, **Push** only updates its timestamp.

## Usage and behavior

Call the child’s **Push** command from its device page or an automation. It is a momentary actuator, not a numbered `PushableButton` event source. `lastPushed` records the command time, not confirmation that playback succeeded; inspect the parent’s command status for the result.

## Device interface

Capabilities: `Actuator`, `Momentary`, `Refresh`.

Additional attributes: `lastPushed`.

## Troubleshooting

- If no playlist starts, verify that the parent created this child and has valid FPP connection settings.
- Inspect the parent’s `lastCommandStatus` and `lastError`; the child does not make network requests itself.

## Updating

Replace the saved driver code in Hubitat with the latest source and save it. Keep existing devices; there is no need to recreate them. Save preferences and refresh as applicable.

## License

[MIT License](LICENSE). Author: Jon Wallace.
