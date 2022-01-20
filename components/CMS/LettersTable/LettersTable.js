import styles from './LettersTable.module.css';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import {Box, Dialog, TablePagination, Tooltip, Typography} from '@material-ui/core';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import IconButton from '@mui/material/IconButton';
import { Delete, Edit } from '@material-ui/icons';
import { useState } from 'react';
import Button2 from "../../Button2/Button2";

const EditIcon = ({ id }) => (
    <Tooltip title="Edytuj literę">
        <IconButton href={`/admin/letters/${id}`}>
            <Edit />
        </IconButton>
    </Tooltip>
);
const DeleteIcon = ({ handleOpen }) => (
    <Tooltip title="Usuń literę">
        <IconButton onClick={() => handleOpen()}>
            <Delete />
        </IconButton>
    </Tooltip>
);

const LettersTable = ({ data, handleDelete }) => {
    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(5);
    const [id, setId] = useState();
    const [open, setOpen] = useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleSetId = (id) => {
        setId(id);
        handleOpen();
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };
    return (
        <>
            <Dialog
                className={styles.modalContainer}
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box>
                    <Typography id="modal-modal-title" variant="h6" component="h2"/>
                    <div className={styles.typoContainer}>
                        <Typography id="modal-modal-description" sx={{ mt: 2, padding: '20' }}>
                            Czy na pewno chcesz usunąć element?
                        </Typography>
                    </div>
                    <div className={styles.buttonsContainer}>
                        <Button2 onClick={() => handleClose()}>
                            Anuluj
                        </Button2>
                        <Button2 onClick={() => handleDelete(id)}>
                            Potwierdź
                        </Button2>
                    </div>
                </Box>
            </Dialog>
            <TableContainer component={Paper} className={styles.tableContainer}>
                <Table
                    sx={{ border: 'none', minWidth: 650 }}
                    aria-label="simple table"
                >
                    <TableHead
                        className={styles.tableContainer__header}
                        sx={{ border: 'none', color: '#fefefe' }}
                    >
                        <TableRow>
                            <TableCell
                                sx={{ border: 'none', color: '#fefefe' }}
                            >
                                Obraz
                            </TableCell>
                            <TableCell
                                sx={{ border: 'none', color: '#fefefe' }}
                            >
                                Litera
                            </TableCell>
                            <TableCell sx={{ border: 'none' }} align="right" />
                        </TableRow>
                    </TableHead>
                    <TableBody sx={{ border: 'none' }}>
                        {(rowsPerPage > 0
                            ? data.slice(
                                  page * rowsPerPage,
                                  page * rowsPerPage + rowsPerPage
                              )
                            : data
                        ).map((row, index) => (
                            <TableRow
                                key={index}
                                sx={{
                                    border: 'none',
                                }}
                            >
                                <TableCell
                                    className={styles.tableContainer}
                                    align="left"
                                    sx={{ border: 'none', color: '#fefefe' }}
                                >
                                    <img
                                        alt={row.transcription}
                                        src={row.image.lightPath}
                                        className={styles.tableImage}
                                    />
                                </TableCell>
                                <TableCell
                                    className={styles.tableContainer}
                                    component="th"
                                    sx={{ border: 'none', color: '#fefefe' }}
                                >
                                    {row.transcription}
                                </TableCell>
                                <TableCell
                                    className={styles.tableContainer}
                                    align="right"
                                    sx={{
                                        marginLeft: 'auto',
                                        border: 'none',
                                        color: '#fefefe',
                                    }}
                                >
                                    <div className={styles.actionButtons}>
                                        <EditIcon id={row.id} />
                                        <DeleteIcon
                                            handleOpen={() => handleSetId(row.id)}
                                        />
                                    </div>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
            <TablePagination
                className={styles.tableContainer__footer}
                rowsPerPageOptions={[5, 10, 25]}
                component="div"
                count={data.length}
                page={page}
                onChangePage={handleChangePage}
                rowsPerPage={rowsPerPage}
                onChangeRowsPerPage={handleChangeRowsPerPage}
            />
        </>
    );
};

export default LettersTable;
